const path = require('path');
const HtmlWebpackPlugin = require('html-webpack-plugin');
const ExtractTextPlugin = require('extract-text-webpack-plugin');
const webpack = require('webpack');

// HTML
const HtmlWebpackPluginConfig = new HtmlWebpackPlugin({
    template: './src/index.html',
    filename: './WEB-INF/views/index.jsp',
    inject: 'body'
});

// css
const ExtractTextPluginConfig = new ExtractTextPlugin("static/css/[name].bundle.css");

const MODE = `${process.env.MODE}`;
console.log(MODE);

let config = {
    entry: ['./src/js/index.js','./src/scss/index.scss'],
    output: {
        path: path.resolve(__dirname, "./../../../../target/user-assessment-module-0.0.1-SNAPSHOT/"),
        filename: "static/js/[name].bundle.js",
        publicPath: '/',
        sourceMapFilename: 'static/js/[name].bundle.map'
    },
    devtool: 'cheap-module-eval-source-map',
    module: {
        loaders: [
            { test: /\.js$/, use: 'babel-loader', exclude: /node_modules/ },
            { test: /\.jsx$/, use: 'babel-loader', exclude: /node_modules/ },
            {
                test: /\.scss$/,
                use: ExtractTextPlugin.extract({
                    fallback: 'style-loader',
                    use: ['css-loader','sass-loader']
                })
            },
            {
                test: /\.(gif|png|jpe?g|svg)$/i,
                use: [
                    'file-loader?hash=sha512&digest=hex&name=images/[hash].[ext]',
                    'image-webpack-loader'
                ]
            },
            {
                test: /\.(eot|[ot]tf|woff|woff2)(\?v=\d+\.\d+\.\d+)?$/,
                use: [
                    'file-loader'
                ]
            }
        ]
    },
    plugins: [
        HtmlWebpackPluginConfig,
        ExtractTextPluginConfig,
        new webpack.NamedModulesPlugin(),
        new webpack.DefinePlugin({
            'process.env.NODE_ENV': JSON.stringify('development')
        })
    ]
};

if(MODE === 'maven'){
	config.output.path = path.resolve(__dirname, "./../");
}

module.exports = config;
