// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.

export const environment = {
    production: false,
    API_HOST: 'http://81.8.3.228:8080/crmapi',
    ISM_API_HOST: 'http://81.8.3.228:8082/ismapi',
    PRINT_TICKET_HOST: 'https://localhost:27015/print',
    CPU_HOST: 'https://localhost:5556/clientid',
    POS_HOST: 'http://localhost:27002',
    EVENT_GROUP_ID: '52189980',
    SOLR_HOST: 'http://www5.biletix.com/solr',
    EVENT_IMAGE_ROOT: 'http://www5.biletix.com/static/images/live/event/eventimages/',
    GROUP_IMAGE_ROOT: 'http://www5.biletix.com/static/images/live/event/groupimages/',
    MEMPROG_IMAGE_ROOT: 'http://www5.biletix.com/static/images/membercards/',
    TIMEOUT: 3600,
    WEBSOCK_EXTEND_TIME: 540,
    CPU: "1004",
    CC_NUMBER_READONLY:true,
    CVV_READONLY : true,
    IP_CHECK_URL: 'https://ipinfo.io',
    JENKINS_BUILD_NUMBER : '_JENKINS_BUILD_NUMBER_'
};