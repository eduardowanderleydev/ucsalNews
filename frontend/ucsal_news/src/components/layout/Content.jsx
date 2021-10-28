import React from 'react'

import {Switch, Route} from 'react-router-dom'

import Home from '../../views/examples/Home'

import '../layout/Content.css'
const Content = props => (
    <main className="Content">
        <Switch>
            <Route exact path ='/Home'>
                <Home/>
            </Route>
        </Switch>
    </main>
)

export default Content;
 