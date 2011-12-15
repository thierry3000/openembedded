require linux-firmware.inc

SRCREV = "46c66487a85cd05a4acbd5eb4828f72783d1be4c"

do_install() {
        install -d ${D}${base_libdir}/firmware
        install -m 0644 dvb-usb-dib0700-01.fw ${D}/${base_libdir}/firmware/
        install -m 0644 dvb-usb-dib0700-03-pre1.fw ${D}/${base_libdir}/firmware/
        install -m 0644 dvb-usb-dib0700-1.10.fw ${D}/${base_libdir}/firmware/
        install -m 0644 dvb-usb-dib0700-1.20.fw ${D}/${base_libdir}/firmware/
}

