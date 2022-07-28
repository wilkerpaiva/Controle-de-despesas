import axios from "axios";

export default axios.create({
    baseURL: 'https://controlede-despesas.herokuapp.com/api'
})