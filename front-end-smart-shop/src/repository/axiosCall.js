import axios from '../custom-axios/axios'
import React from "react";
const ApiService = {

    fetchAllProducts: (page, size)=> {
        return axios.get("/rest/product?page="+page+"&size="+size);
    },
    fetchSizeOfAllProducts:()=>{
        return axios.get("/rest/product/size")
    },
    fetchProductById(id) {
        return axios.get("/rest/product/"+id)
    },
    fetchAllManufacturers() {
        return axios.get("/rest/product/manufacturers")
    },
    fetchAllCategories() {
        return axios.get("/rest/product/categories")
    },
    updateProduct(obj, id) {
        const send = JSON.stringify(obj);
        console.log("THE EXACT PRODUCT");
        console.log(send);
        axios({
            method: 'post',
            headers: { 'content-type': 'application/json' },
            url: '/rest/product/update/'+id,
            data: send,
            redirect:"follow"
        }).then(response => {
            // HTTP 301 response
            if(response.status === 200){
                console.log("Status code is 200, sending redirect to /products. CALL MADE FROM AXIOS!");
                window.location.href = "/products";
            }
        }).catch(function(err) {
                console.info(err);
        });
    },
    addNewProduct(obj) {
        const send = JSON.stringify(obj);
        console.log("after stringify");
        console.log(send);
        axios({
            method: 'post',
            headers: { 'content-type': 'application/json' },
            url: '/rest/product/add',
            data: send,
            redirect:"follow"
        }).then(response => {
            // HTTP 301 response
            if(response.status === 200){
                console.log("Status code is 200, sending redirect to /products. CALL MADE FROM AXIOS!");
               window.location.href = "/products";
            }
        }).catch(function(err) {
            console.info(err);
        });
    },
    addNewManufacturer(obj) {
        const send = JSON.stringify(obj);
        console.log(send);
        axios({
            method: 'post',
            headers: { 'content-type': 'application/json' },
            url: '/rest/product/addmanufacturer',
            data: send,
            redirect:"follow"
        }).then(response => {
            // HTTP 301 response
            if(response.status === 200){
                console.log("Status code is 200, sending redirect to /products. CALL MADE FROM AXIOS!");
                alert("Manufaturer Successfuly Added");
                window.location.href = "/products";
            }
        }).catch(function(err) {
            console.info(err);
        });
    },
    addNewCategory(obj) {
        const send = JSON.stringify(obj);
        console.log(send);
        axios({
            method: 'post',
            headers: { 'content-type': 'application/json' },
            url: '/rest/product/addcategory',
            data: send,
            redirect:"follow"
        }).then(response => {
            // HTTP 301 response
            if(response.status === 200){
                console.log("Status code is 200, sending redirect to /products. CALL MADE FROM AXIOS!");
                alert("Category Successfuly Added");
                window.location.href = "/products";
            }
        }).catch(function(err) {
            console.info(err);
        });
    },
    deleteProduct(id){
        console.log("Ova e idto " + id);
        axios.delete(`/rest/product/delete/${id}`);
        // axios({
        //     method: 'delete',
        //     headers: { 'content-type': 'application/json' },
        //     url: '/rest/product/delete/'+{id},
        // }).then(response => {
        //     // HTTP 301 response
        //     if(response.status === 200){
        //         console.log("Status code is 200, sending redirect to /products. CALL MADE FROM AXIOS!");
        //         alert("Product Successfuly Deleted");
        //     }
        // }).catch(function(err) {
        //     console.info(err);
        // });
    }
}
export default ApiService;