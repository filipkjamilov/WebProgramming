import React from "react";
import ApiService from "../../repository/axiosCall";
import Nav from "../Nav/Nav";

class CategoryAdd extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            name:''
        };
    }

    onChange = (e) => {
        this.setState({ [e.target.name]: e.target.value });
    }

    onSubmit = (e) => {
        e.preventDefault();

        const check = document.getElementById("check");
        if(check.checked){
            // get our form data out of state
            const {name} = this.state;
            const obj = {name};
            ApiService.addNewCategory(obj);
        }else{
            alert("Please agree to Terms and Conditions!");
        }


    }

    render(){
        return(
            <div>
                <div className="container" style={{"padding":"0"}}>
                    <Nav/>
                </div>
                <div>
                    <form className={"container bg-light"} onSubmit={this.onSubmit}>
                        <div>
                            <h1>Add a new Category</h1>
                        </div>
                        <div className="form-row">
                            <div className="form-group col-md-6">
                                <label htmlFor="name">Name</label>
                                <input name="name" onChange={this.onChange} type="text" className="form-control" placeholder="Enter category name"/>
                            </div>
                        </div>
                        <div className="form-check">
                            <input type="checkbox" className="form-check-input" id="check"/>
                            <label className="form-check-label" htmlFor="exampleCheck1">I agree to the <a href="https://google.com">Terms and conditions</a> for adding a new category to the database.</label>
                        </div>
                        <button type="submit" className="btn btn-primary" style={{"width":"100%", "marginBottom":"10px"}}>Submit</button>
                    </form>
                </div>
            </div>
        )
    }
}
export default CategoryAdd;