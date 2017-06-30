using System;
using System.Linq;
using InTheHand.Net.Sockets;
using System.IO;
using System.Runtime.InteropServices;
using InTheHand.Net;
using InTheHand.Net.Bluetooth;

namespace BluetoothLocker
{

    class Program
    {
        [DllImport("user32.dll")]
        public static extern void LockWorkStation();
        public static Guid uuid = new Guid("00001115-0000-1000-8000-00805f9b34fb");

        static void Main(string[] args)
        {
            Console.BackgroundColor = ConsoleColor.White;
            Console.Clear();
            Console.ForegroundColor = ConsoleColor.Black;
            Console.Title = "Bluetooth Locker";
            Console.WriteLine("Please enter in the name of your device(if you changed the bluetooth name enter in the new name) Case Sensitive!");
            string name = Console.ReadLine();
            RecieveCommand(name);
            Console.ReadKey();
        }
        static void RecieveCommand(string name)
        {
            byte[] buffer = new byte[1];
            
            while (true)
            {
                try
                {
                    BluetoothClient bClient = new BluetoothClient();
                    BluetoothDeviceInfo device = bClient.DiscoverDevices().Where(x => x.DeviceName.Contains(name)).FirstOrDefault();
                    BluetoothAddress address = device.DeviceAddress;

                    var endPoint = new BluetoothEndPoint(address, BluetoothService.RFCommProtocol);
                    var client = new BluetoothClient();
                    client.Connect(endPoint);
                    Stream stream = client.GetStream();
                    int input = 0;

                    if (client.Connected)
                    {
                        Console.WriteLine("You are connected!");
                        input = stream.Read(buffer, 0, buffer.Length);

                    }



                    if (input == 0)
                    {
                        LockWorkStation();
                    }
                }catch(Exception)
                {
                    Console.WriteLine("Not Connected");
                }
            }
            
        }
    }
}
