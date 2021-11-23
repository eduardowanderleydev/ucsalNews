import React from 'react'

import { Route, Redirect } from 'react-router-dom'

const PrivateRoute = props => {
    const isLogged = !localStorage.getItem('app-token')
    console.log(isLogged)
    return isLogged? <Route {...props} /> : <Redirect to ="/Login"/>
}

export default PrivateRoute;