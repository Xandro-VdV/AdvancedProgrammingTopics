export interface Message {
    id: string;
    deviceId: number;
    header: string;
    message: string;
    sentAt: Date;
}

export interface MessagePost {
    deviceId: number;
    header: string;
    message: string;
    sentAt: Date;
}
