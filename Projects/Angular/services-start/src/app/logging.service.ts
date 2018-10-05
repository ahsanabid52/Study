export class LoggingService {
    logStatusChange(status: string) {
        console.log('A server status changed, new status: ' + status);
    }

    logString(log: string) {
        console.log(log);
    }
}