import '../../components/App/App.css';
import React from 'react';
import Typography from "@material-ui/core/Typography";
import Container from "@material-ui/core/Container";
import Grid from "@material-ui/core/Grid";
import Button from "@material-ui/core/Button";
import {makeStyles} from "@material-ui/core/styles";
import "react-responsive-carousel/lib/styles/carousel.min.css";
class CenterText extends React.Component {


    render() {

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
        }));



        return (
            <div className={useStyles.heroContent}>

                <Container maxWidth="sm" style={{"marginTop":"20px", "marginBottom":"20px"}}>


                    <Typography component="h1" variant="h2" align="center" color="textPrimary" gutterBottom>
                        Smart - Shop
                    </Typography>
                    <Typography variant="h5" align="center" color="textSecondary" paragraph>
                        Welcome to our brand new page, you can find brand new phones here and buy then in second. Fast, easy and safe!
                    </Typography>
                    <div className={useStyles.heroButtons}>
                        <Grid container spacing={2} justify="center">
                            <Grid item>
                                <Button variant="contained" color="primary">
                                    See all products
                                </Button>
                            </Grid>
                            <Grid item>
                                <Button variant="outlined" color="primary">
                                    Reach us
                                </Button>
                            </Grid>
                        </Grid>
                    </div>
                    <Typography variant="h3" align="center" color="textSecondary" paragraph>
                        Top 3 phones of the week
                    </Typography>
                </Container>



            </div>

        );

    }
}
export default CenterText;
