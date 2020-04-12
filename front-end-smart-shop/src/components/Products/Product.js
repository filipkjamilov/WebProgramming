import React from 'react';
import Grid from "@material-ui/core/Grid";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
import Typography from "@material-ui/core/Typography";
import CardActions from "@material-ui/core/CardActions";
import {makeStyles} from "@material-ui/core/styles";
import ApiService from "../../repository/axiosCall";
import Container from "@material-ui/core/Container";
import CssBaseline from "@material-ui/core/CssBaseline";
import Pagination from "react-js-pagination";
import {Link} from "react-router-dom";

class Product extends React.Component{

    constructor(props) {
        super(props);
        this.state = {
            items: [],
            isLoaded: false,
            activePage: 0,
            pageSize:9,
            totalItemsCount: 0

        };
    }

    loadProducts(page, size){
        if(!this.state.isLoaded) {

            console.log("I just loaded");

            ApiService.fetchAllProducts(page, size).then((data) => {
                this.setState({
                    isLoaded:true,
                    items:data.data
                });
            });

            ApiService.fetchSizeOfAllProducts().then((data) => {
                console.log("DA");
                this.setState({
                    totalItemsCount:data.data
                });

            });
        }
    };


    componentDidMount() {
        if(this.props.pag){
            this.setState({pageSize:9}, ()=>{
                this.loadProducts(this.state.activePage, this.state.pageSize);
            })
        }else{
            this.setState({pageSize:3}, ()=>{
                this.loadProducts(this.state.activePage, this.state.pageSize);
            })
        }

    }

    
        render() {

            const handlePageChange =(pageNumber)=> {
                //Go to top of the page
                window.scrollTo(2, 2);
                this.setState({
                    activePage: pageNumber,
                    isLoaded: false
                }, () => {
                    this.loadProducts(this.state.activePage, this.state.pageSize);
                });

            };



            const useStyles = makeStyles((theme) => ({
                icon: {
                    marginRight: theme.spacing(2),
                },
                heroContent: {
                    backgroundColor: theme.palette.background.paper,
                    padding: theme.spacing(8, 0, 6),
                },
                heroButtons: {
                    marginTop: theme.spacing(4),
                },
                cardGrid: {
                    paddingTop: theme.spacing(8),
                    paddingBottom: theme.spacing(8),
                },
                card: {
                    height: '100%',
                    display: 'flex',
                    flexDirection: 'column',
                },
                cardMedia: {
                    paddingTop: '56.25%', // 16:9
                },
                cardContent: {
                    flexGrow: 1,
                },
                footer: {
                    backgroundColor: theme.palette.background.paper,
                    padding: theme.spacing(6),
                },
                media: {
                    height:280+"px",
                    width:100+"%",
                    margin:"auto",
                }
            }));


            //Loading all necesery styles


            return (
                <React.Fragment>
                    <CssBaseline />

                    <main>
                <Container className={useStyles.cardGrid} maxWidth="md">
                    {/* End hero unit */}
                    <Grid container spacing={4} >

                        {this.state.items.map((card) => (
                            <Grid item key={card.name} xs={12} sm={6} md={4}  >
                                <Card className={useStyles.card}>
                                    <div style={{
                                        "height": "300px",      /* equals max image height */
                                        "width": "280px",
                                        "whiteSpace": "nowrap",
                                        "textAlign": "center",
                                        "margin": "1em 0",}}>
                                        <span style={{
                                            "display": "inline-block",
                                            "height": "100%",
                                            "verticalAlign": "middle",
                                        }}></span>
                                        <img src={card.link} style={{
                                            "verticalAlign": "middle",
                                            "maxHeight": "295px",
                                            "maxWidth": "275px",}}
                                            alt={"This should be image for "+card.name}
                                        />
                                    </div>

                                    <CardContent className={useStyles.cardContent}>
                                        <Typography gutterBottom variant="h5" component="h2" style={{"textAlign":"center"}}>
                                            {card.name}
                                        </Typography>
                                        {this.props.pag &&
                                        <Typography>
                                            {card.description}
                                        </Typography>
                                        }
                                    </CardContent>

                                    <CardActions style={{"float": "bottom"}}>

                                        <Link className="btn btn-dark btn-sm" to={"/products/details?id=" + card.id}>Details</Link>

                                        {this.props.pag &&
                                        <button className="btn btn-danger btn-sm" size="small" color="primary"
                                                onClick={() => {
                                                    this.props.delete(card.id);
                                                    //Ova treba sa se smeni so // if delete.response==200 loadproducts() // setTimeout privremeno
                                                    setTimeout(function () {
                                                        this.setState({isLoaded: false}, () => {
                                                            this.loadProducts(this.state.activePage, this.state.pageSize)
                                                        })
                                                    }.bind(this), 150)
                                                }} id={card.id}>
                                            Delete
                                        </button>
                                        }
                                    </CardActions>

                                </Card>
                            </Grid>
                        ))}
                    </Grid>
                </Container>
                </main>
                    {this.props.pag &&
                    <div style={{"width":"100%","textAlign":"center", "marginTop":"20px"}}>
                    <Pagination
                        activePage={this.state.activePage}
                        itemsCountPerPage={this.state.pageSize}
                        totalItemsCount={this.state.totalItemsCount}
                        onChange={handlePageChange}
                        itemClass="page-item"
                        linkClass="page-link"
                    />
                    </div>
                    }
                </React.Fragment>
            );
        }


}
export default Product