import axios from "../custom-axios/axios";

const LibraryService = {

    fetchCountries: () => {
        return axios.get("/countries")
    },

    fetchAuthors: () => {
        return axios.get("/authors")
    },

    fetchBooks: () => {
        return axios.get("/books")
    }

}

export default LibraryService;