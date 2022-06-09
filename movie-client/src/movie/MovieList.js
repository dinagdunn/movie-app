import React, { Component } from 'react';
import {
    Link
  } from 'react-router-dom';


import { searchForMovie, getRecentlyPlaying } from '../util/APIUtils';
import MovieDetails from './MovieDetails';
import './MovieList.css'

class MovieList extends Component {
    state = {

        moviesList: [],
        searchTerm: ''
    };

    search = event => {
        event.preventDefault();
        searchForMovie(this.state.searchTerm).then(res => {
            this.setState({ moviesList: res })
        })
    };

    async componentDidMount() {
        await getRecentlyPlaying()
            .then(res => {
                this.setState({ moviesList: res });
            });
    }

    handleChange = event => {
        this.setState({
            searchTerm: event.target.value
        });
    };

    render() {
        const { moviesList } = this.state;

        return (
            <div>
                <form onSubmit={this.search}>
                    <input
                        placeholder="Search for a movie"
                        onChange={this.handleChange}
                    />
                    <button type="submit">
                        Search
                    </button>
                </form>
                {moviesList.length > 0 ? (
                    moviesList.map(movie => (
                        <div key={movie.id} className="movie-card-container col-lg-3">
                            <div className="image-container" display="flex">
                                <img src={`https://image.tmdb.org/t/p/w185${movie.poster_path} `} alt="Movie Poster"></img>
                            </div>
                            <div className="movie-info">
                 
                            <Link to={`/movies/details/${movie.id}`} component={MovieDetails}><h2>Movie Details</h2></Link>
        
                                <div>
                                    <h1>{movie.title}</h1>
                                    <small>Released Date: {movie.release_date}</small>
                                </div>
                                <div>
                                    <h4>Rating: {movie.vote_average} / 10</h4>
                                    <p>{movie.overview}</p>
                                </div>
                            </div>
                        </div>
                    ))
                ) : (
                    <p>
                        Couldn't find any movie. Please search again using
                        another search criteria.
                    </p>
                )}
            </div>
        );
    }
}

export default MovieList;