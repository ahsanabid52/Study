package home.practice.basics.interfaces;

@FunctionalInterface
public interface SeriesGenerator {

  String generateSeries(int startingPoint, int diff, int cycles);

}