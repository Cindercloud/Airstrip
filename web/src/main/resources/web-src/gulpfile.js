'use strict';

/* do NOT change the order of the pipes as this could cause unwanted effects */
var pkg = require('./package.json'),
    del = require('del'),
    gulp = require('gulp'),
    autoprefixer = require('gulp-autoprefixer'),
    bless = require('gulp-bless'),
    cached = require('gulp-cached'),
    concat = require('gulp-concat'),
    copy = require('gulp-copy'),
    eslint = require('gulp-eslint'),
    htmllint = require('gulp-htmllint'),
    notify = require('gulp-notify'),
    plumber = require('gulp-plumber'),
    uglify = require('gulp-uglify'),
    gUtil = require('gulp-util'),
    fileExists = require('file-exists'),
    rename = require('gulp-rename'),
    gutil = require('gulp-util'),
    fs = require('fs');

var paths = {
    unify: [
        "unify/**"
    ],
    scripts: [
        "asset/js/*"
    ],
    css: [
        "asset/css/*"
    ],
    img: [
        "images/*"
    ],
    fonts: ["asset/fonts/*"]
};

// helper functions
function onError(err) {
    gUtil.log('\n', gUtil.colors.bold(gUtil.colors.red('Error ocurred: ') + err.message + ' @ ' + err.fileName + ':' + err.lineNumber), '\n');
    gUtil.beep();
    this.emit('end');
}

// clean folders
gulp.task('clean', function() {
    pkg.clean.forEach(function(path) {
        return del.sync(path, {
            'force': true
        });
    });
});

//  Images
gulp.task('imgbuild', function() {
    return gulp
        .src(paths.img)
        .pipe(gulp.dest('../static/assets/images/'));
});

gulp.task('jsbuild', function() {
    return gulp
        .src(paths.scripts)
        .pipe(gulp.dest('../static/assets/js/'));
});

gulp.task('unifybuild', function() {
    return gulp
        .src(paths.unify)
        .pipe(gulp.dest('../static/assets/unify/'));
});

// CSS
gulp.task('cssbuild', function() {
    return gulp
        .src(paths.css)
        .pipe(gulp.dest('../static/assets/css/'));
});

//FONTS
gulp.task('fontbuild', function() {
    return gulp
        .src(paths.fonts)
        .pipe(gulp.dest('../static/assets/fonts/'));
});

// default task
gulp.task('build', ['clean'], function() {
    gulp.start('imgbuild');
    gulp.start('fontbuild');
    gulp.start('cssbuild');
    gulp.start('jsbuild');
    gulp.start('unifybuild');
});

gulp.task('default', ['build']);
