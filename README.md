# Open918
*BSD License*

A library to parse the contents of UIC 918 tickets. UIC 918.2 and 918.3 is a UIC standard for several kinds of tickets that are used in domestic and international railways and other public transport.

Note, this library only parses the contents of barcodes, and doesn't actually decode the barcode itself or perform image decoding/transformation. Please use Zxing or another commercial implementation to get the contents of a barcode image.

Java Source is compatible with Android and thus at Java 1.7 language level.

## Features
This library is beta quality - it's nowhere feature complete but has fairly mature parsing capabilities. It is currently used by the [MyFirstRailpocket app](https://play.google.com/store/apps/details?id=nl.waarisdetrein.myfirstrailpocket), available on Google Play.

### Implemented
* Support for 918.2 tickets
* Support for RCT2 field encoding and limited support for EOSU standard

### Missing
* Support for reading and verifying the digital signature of tickets
* Support for 918.3 tickets/barcodes

## Usage
Build and import this library in your application, for instance by specifying it in your gradle build file:

```compile "org.open918:open918:1.0-SNAPSHOT" ```

For an example of using this in Android context, please see the ``sample-app-android`` project.

## Sources
The UIC 918.2 and 918.3 standards are only available to UIC members (i.e. railway companies in some form). Therefore, this library was reverse engineered and based on the following work:

- Presentation and code by Hagen Fritsch, [available here](https://github.com/rumpeltux/onlineticket/blob/master/onlineticket.py) (this version has support for more German-specific formats and fields)
- After much Google-fu, a Russian-language version of the documentation was found which is particularly helpful for data tables
- An open folder of an Iranian university with various UIC leaflets
- Various contributed tickets by users of MyFirstRailpocket (thanks!)

## Contributors and Contributing

This library is based on work by BliksemLabs:

* Thomas Koch
* Joel Haasnoot

Pull requests are appreciated, please ensure all tests pass.