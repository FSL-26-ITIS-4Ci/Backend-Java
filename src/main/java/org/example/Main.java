package org.example;

import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Sintassi:\n    java Main <tag> <fileout>");
            return;
        }

        Set<String> preferences = Set.of(args[0].toLowerCase().trim().split(", ?"));

        GameJsonMapper mapper = new GameJsonMapper();
        List<Game> games = mapper.readGames(Paths.get("src/main/resources/games.json"));

        List<Game> sorted = JaccardSorter.sortBySimilarity(games, preferences);

        mapper.writeGames(Paths.get(String.format("src/main/resources/%s.json", args[1])), sorted);
        printTopMatches(sorted, 10);
    }

    private static void printTopMatches(List<Game> games, int count) {
        System.out.println("\nTop " + count + " matches:");
        for (int i = 0; i < Math.min(count, games.size()); i++) {
            Game g = games.get(i);
            System.out.printf("%2d. %-40s (%d%%)%n",
                    i + 1,
                    g.getNome(),
                    g.getAffinity() != null ? g.getAffinity() : 0
            );
        }
    }
}