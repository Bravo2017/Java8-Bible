package com.ccreanga.example.java8.lambda.similarity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Similarity {

    private static Double sum(List<Double> a){
        return IntStream.range(0, a.size()).mapToDouble(a::get).sum();
    }

    private static Double squareSum(List<Double> a){
        return IntStream.range(0, a.size()).mapToDouble(i -> a.get(i) * a.get(i)).sum();
    }

    private static Double dotProduct(List<Double> a, List<Double> b){
        return IntStream.range(0, a.size()).mapToDouble(i -> a.get(i) * b.get(i)).sum();
    }

    private static Double magnitude(List<Double> a){
        return Math.sqrt(a.stream().mapToDouble(el -> el * el).sum());
    }

    public static Double cosineSimilarity(List<Double> a, List<Double> b){
        return dotProduct(a,b) / (magnitude(a)*magnitude(b));
    }

    public static Double pearsonCorrelation(List<Double> a, List<Double> b){
        int len  = a.size();

        double num = dotProduct(a,b) - (sum(a)*sum(b))/len;
        double div = Math.sqrt( (squareSum(a)-sum(a)*sum(a)/len) * (squareSum(b)-sum(b)*sum(b)/len) );
        return div==0?0:num/div;
    }

    public static void main(String[] args) {

        System.out.println(sum(Arrays.asList(1d, 2d, 3d)));
        System.out.println(squareSum(Arrays.asList(1d, 2d, 3d)));
        System.out.println(dotProduct(Arrays.asList(1d, 2d, 3d), Arrays.asList(2d, 4d, 6d)));
        System.out.println(magnitude(Arrays.asList(1d, 2d, 3d)));


        System.out.println(
                cosineSimilarity(
                        Arrays.asList(1d, 2d, 3d),
                        Arrays.asList(2d, 4d, 6d)));

        System.out.println(
                pearsonCorrelation(
                        Arrays.asList(1d, 2d, 3d),
                        Arrays.asList(2d, 4d, 6d)));
    }

}
