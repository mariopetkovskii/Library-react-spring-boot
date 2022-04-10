import logo from '../../logo.svg';
import './App.css';
import {
    Routes,
    Navigate,
    Route
} from 'react-router-dom';
import {Component} from "react";
import Countries from "../Countries/countries";
import LibraryService from "../../repository/libraryRepository";
import Authors from "../Authors/authors";
import Books from "../Books/books";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            countries: [],
            authors: [],
            books: []
        }
    }

    render() {
        return (
            <main>
                <div className="container">
                    <Routes>
                        <Route path="/countries" exact element={<Countries countries={this.state.countries}/>}/>
                        <Route path="/authors" exact element={<Authors authors={this.state.authors}/>}/>
                        <Route path="/books" exact element={<Books books={this.state.books}/>}/>
                    </Routes>

                </div>
            </main>
        )
    }

    loadCountries = () => {
        LibraryService.fetchCountries()
            .then((data) => {
                this.setState({
                    countries: data.data
                })
            });
    }

    loadAuthors = () => {
        LibraryService.fetchAuthors()
            .then((data)=>{
                this.setState({
                    authors: data.data
                })
            });
    }

    loadBooks = () => {
        LibraryService.fetchBooks()
            .then((data)=>{
                this.setState({
                    books: data.data
                })
            });
    }

    componentDidMount() {
        this.loadCountries();
        this.loadAuthors();
        this.loadBooks();
    }


}

export default App;
