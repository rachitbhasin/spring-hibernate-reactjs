
// The env parameter is set via --env in the package.json
module.exports = function(env) {
  return require(`./webpack.${env}.js`)
}
