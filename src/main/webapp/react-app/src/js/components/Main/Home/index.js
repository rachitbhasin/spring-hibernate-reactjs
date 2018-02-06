import React from 'react';
import { connect } from 'react-redux';
import Home from './render.jsx';
import { updateQuery } from './actionCreators';

const mapStateToProps = (state, ownProps) => {
    return {
        names: state.home.names,
        query: state.home.query
    }
};

const mapDispatchToProps = (dispatch, ownProps) => {
    return {
        onQueryChange: (query) => {
            dispatch(updateQuery(query));
        }
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(Home);
