DESCRIPTION = "tool to switch multidevice usb modes"
LICENSE = "GPL"

DEPENDS = "libusb"

PV=1.2.3
SRC_URI = "http://www.draisberghof.de/usb_modeswitch/usb-modeswitch-${PV}.tar.bz2"

S = "${WORKDIR}/usb-modeswitch-${PV}"

do_install() {
        install -d ${D}${bindir}
        install -m 0755 ${S}/usb_modeswitch ${D}${bindir}
}

