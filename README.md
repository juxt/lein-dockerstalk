# dockerstalk

A plugin to deploy Dockerfiles to AWS Beanstalk. This plugin wraps `lein-beanstalk`.

## Usage

Put `[dockerstalk "0.1.0-SNAPSHOT"]` into the `:plugins` vector of your project.clj.

Configure you project as you would in `lein-beanstalk`.

````
lein dockerstalk deploy dev {path-to-zip-file}
````

You need to build the ZIP file in advance, containing typically just the Dockerfile and the uberjar (you can use `lein-zip`).

Note that `lein-dockerstalk` may well get factored into `lein-beanstalk` in the future.

## License

Copyright © 2015 JUXT

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
