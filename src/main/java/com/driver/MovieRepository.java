package com.driver;

import java.util.*;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {

    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMapping;

    public MovieRepository(){
        this.movieMap = new HashMap<String, Movie>();
        this.directorMap = new HashMap<String, Director>();
        this.directorMovieMapping = new HashMap<String, List<String>>();
    }

    public void saveMovie(Movie movie){
        // your code here
        String movieName = movie.getName();
        movieMap.put(movieName,movie);
        System.out.println("added movie " + movieName);
    }

    public void saveDirector(Director director){
        // your code here
        String directorName = director.getName();
        directorMap.put(directorName,director);
    }

    public void saveMovieDirectorPair(String movie, String director){
        if(movieMap.containsKey(movie) && directorMap.containsKey(director)){
            List<String> movieList = directorMovieMapping.getOrDefault(director, new ArrayList<>());
            movieList.add(movie);
            directorMovieMapping.put(director,movieList);
        }



    }

    public Movie findMovie(String movie){
        // your code here
        if(movieMap.containsKey(movie)){
            return movieMap.get(movie);
        }
        return null;
    }

    public Director findDirector(String director){
        // your code here
        if(directorMap.containsKey(director)){
            return directorMap.get(director);
        }
        return null;
    }

    public List<String> findMoviesFromDirector(String director){
        // your code here
        if(directorMovieMapping.containsKey(director)){
            List<String> movies = directorMovieMapping.get(director);
            return movies;
        }
        return null;
    }

    public List<String> findAllMovies(){
        if(!movieMap.isEmpty()) {
            return new ArrayList<>(movieMap.keySet());
        }
        return null;
    }

    public void deleteDirector(String director){
        // your code here

        if(directorMovieMapping.containsKey(director)){
            directorMovieMapping.remove(director);
        }
        if (directorMap.containsKey(director)) {
            directorMap.remove(director);
        }

    }

    public void deleteAllDirector(){
        // your code here
        if(!directorMovieMapping.isEmpty()) {
            directorMovieMapping.clear();
        }
        if (!directorMap.isEmpty()) {
            directorMap.clear();
        }
    }
}