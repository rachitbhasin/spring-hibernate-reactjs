import React from 'react'
import { connect } from 'react-redux';
import Header from './Header'
import Main from './Main'

const App = () => (
    <div>
        <Header />
        <Main />
    </div>
);

// const mapStateToProps = (state, ownProps) => {
//     return {}
// };
//
// const mapDispatchToProps = (dispatch) => {
//     return {
//     }
// };
//
// export default connect(mapStateToProps, mapDispatchToProps)(App);

export default App;