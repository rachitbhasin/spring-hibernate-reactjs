import React from 'react';
import propTypes from 'prop-types';

class Home extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <h3>Home</h3>
                <input type="text" onChange={(e)=>{this.props.onQueryChange(e.target.value)}} placeholder="Search"/>
                <br/>
                <ol>
                    {
                        this.props.names.map(
                            (name, index) => name.indexOf(this.props.query) !== -1
                                ?
                                <li key={index}>{ name }</li>
                                :
                                null
                        )
                    }
                </ol>
            </div>
        )
    }
}

Home.propTypes = {
    // Connected values
    query: propTypes.string.isRequired,
    names: propTypes.arrayOf(propTypes.string).isRequired,
    // Connected Functions
    onQueryChange: propTypes.func.isRequired,
};

export default Home;