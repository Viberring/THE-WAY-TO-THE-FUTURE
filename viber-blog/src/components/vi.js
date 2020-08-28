import React from 'react'
import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link,
    useRouteMatch
} from "react-router-dom";

export default function Vi() {
    let { path, url } = useRouteMatch();
    return (
        <div id='interview'>

          <ul>
            <li><Link to={`${url}/java`}>Java</Link></li>
            <li><Link to={`${url}/mysql`}>Mysql</Link></li>
            <li><Link to={`${url}/redis`}>Redis</Link></li>
          </ul>
          <Switch>
            <Route exact path={`${path}/java`}>
              <div>Java</div>
            </Route>
            <Route path={`${path}/mysql`}>
              <div>Mysql</div>
            </Route>
            <Route path={`${path}/redis`}>
              <div>Redis</div>
            </Route>
          </Switch>
          
        </div>
    )
}

