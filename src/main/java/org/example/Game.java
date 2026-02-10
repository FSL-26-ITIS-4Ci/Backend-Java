package org.example;

import java.util.Set;
import java.util.HashSet;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Game {
    private String nome;
    private Set<String> tag = new HashSet<>();
    private double prezzo;
    private String studio;
    private Set<String> piattaforme = new HashSet<>();
    private Integer pegi;
    private boolean crossPlay;
    private Integer affinity;

    public String getNome() { return nome; }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getStudio() { return studio; }
    public void setStudio(String studio) {
        this.studio = studio;
    }

    public Set<String> getPiattaforme() { return piattaforme; }
    public void setPiattaforme(Set<String> piattaforme) {
        this.piattaforme = normalizeSet(piattaforme);
    }

    public Set<String> getTag() { return tag; }
    public void setTag(Set<String> tag) {
        this.tag = normalizeSet(tag);
    }

    public Integer getAffinity() { return affinity; }
    public void setAffinity(Integer affinity) { this.affinity = affinity; }

    public double getPrezzo() { return prezzo; }
    public void setPrezzo(double prezzo) { this.prezzo = prezzo; }

    public Integer getPegi() { return pegi; }
    public void setPegi(Integer pegi) { this.pegi = pegi; }

    public boolean isCrossPlay() { return crossPlay; }
    public void setCrossPlay(boolean crossPlay) { this.crossPlay = crossPlay; }

    private Set<String> normalizeSet(Set<String> set) {
        Set<String> temp = new HashSet<>();
        for (String i : set){
            temp.add(i.toLowerCase().trim());
        }
        return temp;
    }

    @Override
    public String toString() {
        return "Game{" +
                "nome='" + nome + '\'' +
                ", tag=" + tag +
                ", prezzo=" + prezzo +
                ", studio=" + studio +
                ", piattaforme=" + piattaforme +
                ", pegi=" + pegi +
                ", crossPlay=" + crossPlay +
                ", affinity=" + affinity +
                '}';
    }
}