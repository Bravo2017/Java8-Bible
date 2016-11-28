package org.codefx.lab.stream;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

import static java.util.Objects.requireNonNull;

/**
 * Finds a certain customer in a collection of customers.
 * <p/>
 * All containing code is released into the public domain via
 * <a href="http://creativecommons.org/publicdomain/zero/1.0/">CC0 1.0</a>
 * by <a href="mailto:nipa@codefx.org">Nicolai Parlog</a>.
 */
public class FindFirstFindAnyCollectToOnlyElement {

	private Collection<Customer> customers;

	// FINDING

	public Optional<Customer> findCustomer_Loop(String customerId) {
		for (Customer customer : customers)
			if (customer.getId().equals(customerId))
				return Optional.of(customer);
		return Optional.empty();
	}

	public Optional<Customer> findCustomer_Stream(String customerId) {
		return customers.stream()
				.filter(customer -> customer.getId().equals(customerId))
				.findFirst();
	}

	public Optional<Customer> findOnlyCustomer_Loop(String customerId) {
		boolean foundOneCustomer = false;
		Customer foundCustomer = null;
		for (Customer customer : customers)
			if (customer.getId().equals(customerId))
				if (!foundOneCustomer) {
					foundOneCustomer = true;
					foundCustomer = customer;
				} else
					throw new DuplicateCustomerException();

		return foundOneCustomer ? Optional.of(foundCustomer) : Optional.empty();
	}

	public Optional<Customer> findOnlyCustomer_StreamWithDefaultException(String customerId) {
		return customers.stream()
				.filter(customer -> customer.getId().equals(customerId))
				.collect(onlyElement());
	}

	public Optional<Customer> findOnlyCustomer_StreamWithSpecificException(String customerId) {
		return customers.stream()
				.filter(customer -> customer.getId().equals(customerId))
				.collect(onlyElementThrowing(DuplicateCustomerException::new));
	}

	// THE FOLLOWING WOULD GO INTO SOME UTILITY CLASS

	public static <T> Collector<T, ?, Optional<T>> onlyElement() {
		return onlyElementThrowing(IllegalArgumentException::new);
	}

	public static <T, E extends RuntimeException> Collector<T, ?, Optional<T>> onlyElementThrowing(
			Supplier<E> exception) {
		return new ToOnlyElementCollector<>(exception);
	}

	private static class ToOnlyElementCollector<T, EX extends RuntimeException>
			implements Collector<T, Object[], Optional<T>> {

		private final Supplier<EX> duplicateElementException;

		private ToOnlyElementCollector(Supplier<EX> duplicateElementException) {
			this.duplicateElementException = requireNonNull(
					duplicateElementException, "The argument 'duplicateElementException' must not be null.");
		}

		@Override
		public Supplier<Object[]> supplier() {
			return () -> new Object[1];
		}

		@Override
		public BiConsumer<Object[], T> accumulator() {
			return (container, element) -> {
				if (container[0] == null)
					container[0] = element;
				else
					throw duplicateElementException.get();
			};
		}

		@Override
		public BinaryOperator<Object[]> combiner() {
			return (container1, container2) -> {
				if (container1[0] != null && container2[0] != null)
					throw duplicateElementException.get();
				else if (container1[0] != null)
					return container1;
				else if (container2[0] != null)
					return container2;

				// return any container
				return container1;
			};
		}

		@Override
		@SuppressWarnings("unchecked")
		public Function<Object[], Optional<T>> finisher() {
			return container -> Optional.ofNullable((T) container[0]);
		}

		@Override
		public Set<Characteristics> characteristics() {
			return Collections.singleton(Characteristics.UNORDERED);
		}
	}

	// INNER CLASSES

	public static class Customer {

		private final String id;

		private Customer(String id) {
			this.id = requireNonNull(id);
		}

		private String getId() {
			return id;
		}
	}

	public static class DuplicateCustomerException extends RuntimeException {

	}

}