require linux-firmware.inc

SRCREV = "46c66487a85cd05a4acbd5eb4828f72783d1be4c"

do_install() {
        install -d ${D}${base_libdir}/firmware
        install -m 0644 dvb-usb-dibusb-6.0.0.8.fw ${D}/${base_libdir}/firmware/
        install -m 0644 dvb-usb-dibusb-an2235-01.fw ${D}/${base_libdir}/firmware/
        install -m 0644 dvb-usb-dibusb-5.0.0.11.fw ${D}/${base_libdir}/firmware/
}

