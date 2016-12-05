@FunctionalInterface
public interface BiFunctionWithCE<T, U, R, X extends Exception> {
  R apply(T t, U u) throws X;
}
  