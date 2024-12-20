export interface Device {
    id: number;
    houseId: string;
    name: string;
    brand: string;
    model: string;
    status: string;
    active: boolean;
}

export interface DevicePost {
    houseId: string;
    name: string;
    brand: string;
    model: string;
    status: string;
    active: boolean;
}