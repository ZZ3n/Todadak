module.exports = {
    publicPath: '/',
    outputDir: '../src/main/resources/static',
    indexPath: '../static/index.html',
    css: {
        loaderOptions: {
            sass: {
                prependData: `
                    @import "@/assets/sass/app.sass";
                `,
            }
        }
    },
    lintOnSave: false,
}