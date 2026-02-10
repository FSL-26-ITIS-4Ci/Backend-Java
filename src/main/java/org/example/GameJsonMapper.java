package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GameJsonMapper {
    private final ObjectMapper mapper = new ObjectMapper();

    public List<Game> readGames(Path path) throws IOException {
        return mapper.readValue(Files.newBufferedReader(path), new TypeReference<List<Game>>(){});
    }

    public void writeGames(Path path, List<Game> games) throws IOException {
        mapper.writerWithDefaultPrettyPrinter().writeValue(Files.newBufferedWriter(path), games);
    }
}