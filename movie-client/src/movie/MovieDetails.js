import React from 'react';
import { withRouter } from 'react-router-dom';

import { getMovie } from '../util/APIUtils';
import './MovieList.css'

class MovieDetails extends React.Component {
    state = {
        movie: []
    }

    async componentDidMount() {
        // const {params } = useParams()
        console.log(this.props.match.params.id)
        await getMovie(this.props.match.params.id)
            .then(res => {
                this.setState({ movie: res });
            });
    }
    render() {
        const { movie } = this.state

        return (
            // <Link to={`/movies`}>Back</Link>
                <div key={movie.id} className="movie-card-container col-lg-3">
                    <div className="image-container" display="flex">
                        <img src={`https://image.tmdb.org/t/p/w185${movie.poster_path} `} alt="Movie Poster"></img>
                    </div>
                    <div className="movie-info">
                        <h2>Movie Details</h2>
                        <div>
                            <h1>{movie.title}</h1>
                            <small>Released Date: {movie.release_date}</small>
                        </div>
                        <div>
                            <h4>Rating: {movie.vote_average} / 10</h4>
                            <h4>Budget: {movie.budget} </h4>
                            <p>{movie.overview}</p>
                        </div>
                    </div>
                </div>
        );
    }
}


export default withRouter(MovieDetails);