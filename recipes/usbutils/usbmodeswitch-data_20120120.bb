DESCRIPTION = "tool to switch multidevice usb modes"
LICENSE = "GPL"

PV="20120120"
SRC_URI=" \
	http://www.draisberghof.de/usb_modeswitch/usb-modeswitch-data-${PV}.tar.bz2 \
	file://usb-modeswitch-data_20120215.patch;patch=1\
	"

S = "${WORKDIR}/usb-modeswitch-data-${PV}"

do_compile() {
}

do_install() {
	#install -d ${D}/usr/share/usb_modeswitch
	#install -d ${D}/etc/usb_modeswitch.d
	#install -d ${D}/lib/udev/rules.d
	#install -m 0755 ${S}/40-usb_modeswitch.rules ${D}/lib/udev/rules.d/
	#install -m 0755 ${S}/usb_modeswitch.d/* ${D}/usr/share/usb_modeswitch/
	DESTDIR=${D} make install
}

PACKAGES =+ "usbmodeswitch-data"
FILES_${PN} += "/etc /lib /usr"
#FILES_${PN} += "/lib"
#FILES_${PN} += "/usr"
