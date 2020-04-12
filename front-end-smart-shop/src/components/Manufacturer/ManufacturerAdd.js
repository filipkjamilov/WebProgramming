import React from "react";
import ApiService from "../../repository/axiosCall";
import Nav from "../Nav/Nav";
class ManufacturerAdd extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            name:'',
            country:''
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
            const {name, country } = this.state;
            const obj = {name, country};
            ApiService.addNewManufacturer(obj);
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
                            <h1>Add a new Manufacturer</h1>
                        </div>
                        <div className="form-row">
                            <div className="form-group col-md-6">
                                <label htmlFor="name">Name</label>
                                <input name="name" onChange={this.onChange} type="text" className="form-control" placeholder="Enter manufacturer name"/>
                            </div>
                            <div className="form-group col-md-6">
                                <label htmlFor="country">Country</label>
                                <input onChange={this.onChange} name="country" type="text" className="form-control" placeholder="Country"/>
                            </div>
                        </div>
                        <div className="form-check">
                            <input type="checkbox" className="form-check-input" id="check"/>
                            <label className="form-check-label" htmlFor="exampleCheck1">I agree to the <a href="https://google.com">Terms and conditions</a> for adding a new manufacturer to the database.</label>
                        </div>
                        <button type="submit" className="btn btn-primary" style={{"width":"100%", "marginBottom":"10px"}}>Submit</button>
                    </form>
                </div>
            </div>
        )
    }
}
export default ManufacturerAdd;