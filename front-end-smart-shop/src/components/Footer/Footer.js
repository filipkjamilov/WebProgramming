import React from 'react';
import Container from '@material-ui/core/Container';
import Typography from '@material-ui/core/Typography';
import Link from '@material-ui/core/Link';
import "./Footer.css"
function Copyright() {
    return (
        <Typography variant="body2" align="center">
            {'Copyright © '}
            <Link  href="https://smartshop.com/">
                SmartShop
            </Link>{' '}
            {new Date().getFullYear()}
            {'.'}
        </Typography>
    );
}



export default function Footer() {
    const description = "This is the project for Web programing! Coded & Designed by Filip Kjamilov 163190";
    const title = "Simple shop for smart products!";
    return (
        <div className={"footer"}>
            <footer className={"footerF"}>
                <Container maxWidth="lg">
                    <Typography variant="h6" align="center" gutterBottom>
                        {title}
                    </Typography>
                    <Typography variant="subtitle1" align="center"  component="p">
                        {description}
                    </Typography>
                    <Copyright />
                </Container>
            </footer>
        </div>

    );
}
