package org.codefx.lab.stream;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

/**
 * Finds a certain customer in a collection of customers.
 * <p/>
 * All containing code is released into the public domain via
 * <a href="http://creativecommons.org/publicdomain/zero/1.0/">CC0 1.0</a>
 * by <a href="mailto:nipa@codefx.org"> Nicolai Parlog</a>.
 * <p>
 * See <a href="http://blog.codefx.org/java/beware-stream-findfirst-findany/">this post</a>
 * to read up what this is about.
 */
public class FindFirstFindAnyReduceToOnlyElement {

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

	public Optional<Customer> findOnlyCustomer_StreamWithManualException(String customerId) {
		return customers.stream()
				.filter(customer -> customer.getId().equals(customerId))
				.reduce((element, otherElement) -> {
					throw new DuplicateCustomerException();
				});
	}

	public Optional<Customer> findOnlyCustomer_Stream(String customerId) {
		return customers.stream()
				.filter(customer -> customer.getId().equals(customerId))
				.reduce(toOnlyElementThrowing(DuplicateCustomerException::new));
	}

	// THE FOLLOWING WOULD GO INTO SOME UTILITY CLASS

	public static <T> BinaryOperator<T> toOnlyElement() {
		return toOnlyElementThrowing(IllegalArgumentException::new);
	}

	public static <T, E extends RuntimeException> BinaryOperator<T> toOnlyElementThrowing(
			Supplier<E> exception) {
		return (element, otherElement) -> {
			throw exception.get();
		};
	}

	// INNER CLASSES

	public static class Customer {

		private final String id;

		private Customer(String id) {
			this.id = Objects.requireNonNull(id);
		}

		private String getId() {
			return id;
		}
	}

	public static class DuplicateCustomerException extends RuntimeException {

	}

}