package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class JaccardSorter {

    public static double jaccard(Set<String> a, Set<String> b) {
        if ((a == null || a.isEmpty()) && (b == null || b.isEmpty())) return 0.0;
        Set<String> inter = new HashSet<>();
        if (a != null) inter.addAll(a);
        inter.retainAll(b == null ? Collections.emptySet() : b);

        Set<String> uni = new HashSet<>();
        if (a != null) uni.addAll(a);
        if (b != null) uni.addAll(b);

        if (uni.isEmpty()) return 0.0;
        return (double) inter.size() / (double) uni.size();
    }

    public static int similarity(Game game, Set<String> reference) {
        if (game == null) return 0;

        Set<String> gameSet = new HashSet<>();
        if (game.getPiattaforme() != null) gameSet.addAll(game.getPiattaforme());
        if (game.getTag() != null) gameSet.addAll(game.getTag());

        double jaccardScore = jaccard(gameSet, reference);
        return (int) Math.round(jaccardScore * 100);
    }

    public static List<Game> sortBySimilarity(List<Game> games, Set<String> reference) {
        if (games == null || games.isEmpty()) return games;
        List<Game> copy = new ArrayList<>(games);

        for (Game g : copy) {
            int sim = similarity(g, reference);
            g.setAffinity(sim);
        }

        copy.sort(Comparator.comparingInt((Game g) -> g.getAffinity() == null ? 0 : g.getAffinity()).reversed());
        return copy;
    }
}