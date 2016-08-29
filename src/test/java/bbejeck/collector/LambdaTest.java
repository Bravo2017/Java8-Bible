package bbejeck.collector;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import org.junit.Test;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class LambdaTest {

    private List<String> names = Lists.newArrayList("foo","1","bar","2","baz","3");

    @Test
    public void testOf() throws Exception {
       String expectedValue = "foo1bar2baz3";
       StringBuilder builder = names.stream().collect(CustomCollectors.of(StringBuilder::new, StringBuilder::append));
       assertThat(builder.toString(),is(expectedValue));
    }

    @Test(expected = RuntimeException.class)
    public void testOf_parallel() throws Exception {
        StringBuilder builder = names.stream().parallel().collect(CustomCollectors.of(StringBuilder::new, StringBuilder::append));
    }
    @Test
    public void supplierTest() {
        final AtomicInteger count = new AtomicInteger(65);
        Supplier<Character> supplier =() -> (char)count.getAndIncrement();
        assertThat(supplier.get(),is('A'));
    }
    @Test
    public void unaryOperatorTest(){
        UnaryOperator<Character> operator =(c) -> (char)( (int)c+1);
        
        char character ='A';
        assertThat(operator.apply(character),is('B'));
        
       }
    @Test
    public void function_T_R() {
        
        Function<String[],String>function =(array)-> array[1];
        String[] line =  new String[] { "1" ,"Mike","mathatemics","89"};
       
        assertThat(function.apply(line),is("Mike"));
    }
    @Test
    public void Optional_Test (){
        
        Stream<Integer>stream =Stream.of(1,2,3,4);
        assertThat(stream.max(Comparator.naturalOrder()).get(),is(4));
    }
    
    @Test
    public void newMathTest_for_Optional() {
        double[] doubles ={1.0,2.0,-1.0,0.0};
        List<Double>result= new ArrayList<>();
        DoubleStream.of(doubles).forEach(d->NewMath.sqrt(d).ifPresent(result::add));
        assertThat(result.size(),is(2));
        Function<Double,Optional<Double>>f= d->NewMath.inv(d).flatMap(NewMath::sqrt);
        Function<Double,Stream<Double>>f2= d->NewMath.inv(d).flatMap(NewMath::sqrt).map(Stream::of).orElseGet(Stream::empty);
        List<Double> doubles2 = Arrays.asList(-1d, 0d, 1d) ;
        List<Double> doubles3=doubles2.stream().parallel().flatMap(f2).collect(Collectors.toList()) ;
        assertThat(doubles3.size(),is(1));
    }
    public static class NewMath {
        public static Optional<Double>sqrt(Double d) {
            return d>0 ? Optional.of(Math.sqrt(d)):Optional.empty();
        }
        
        public static Optional<Double> inv(Double d) {
            return d!=0 ? Optional.of(1/d):Optional.empty();
        }
    }
    
}