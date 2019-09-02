module.exports = {
    outputDir: "../src/main/resources/static", // 배포 후 파일을 생성할 경로
    indexPath: "../static/index.html", // index파일이 생성될 위치
    devServer: {
        proxy: "http://localhost:8080" // 스프링 부트의 내장 was 주소
    },
    // chainWebpack: config => {
    //     const svgRule = config.module.rule("svg");
    //     svgRule.uses.clear();
    //     svgRule.use("vue-svg-loader").loader("vue-svg-loader");
    // }
};