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
    },

    fetchCategories: () => {
        return axios.get("/categories")
    },

    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`)
    },

    addBook: (name, category, author, availableCopies) => {
        return axios.post("/books/add", {
            "name" : name,
            "category" : category,
            "author" : author,
            "availableCopies" : availableCopies
        });
    },

    markAsTaken: (id) => {
        return axios.put(`/books/mark/${id}`)
    }

}

export default LibraryService;