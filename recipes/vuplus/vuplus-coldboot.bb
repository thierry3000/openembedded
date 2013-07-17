DESCIPTION = "S3 cold boot"
MAINTAINER = "vuplus team"


PV = "1.0"
PR = "r0"
SRC_REV = ""

SRC_URI = "file://coldboot \
	   file://coldboot.sh"

do_install() {
	install -d ${D}/etc/init.d \
		${D}/usr/bin \
        	${D}${sysconfdir}/rc0.d 

	install -m 0755 ${WORKDIR}/coldboot.sh ${D}/etc/init.d/coldboot.sh
	install -m 0755 ${WORKDIR}/coldboot ${D}/usr/bin/coldboot
        ln -sf   ../init.d/coldboot.sh ${D}${sysconfdir}/rc0.d/S30coldboot.sh
}
