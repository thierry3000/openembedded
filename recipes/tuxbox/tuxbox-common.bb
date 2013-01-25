DESCRIPTION = "Tuxbox common files"
LICENSE = "GPL"
MAINTAINER = "Felix Domke <tmbinc@elitdvb.net>"

PN = "tuxbox-common"
PR = "r4"

SRC_REV = "8ef7a7f5f5df5f77197ad279e24b0dc454b8210b"

SRC_URI = "git://git.code.sf.net/p/tuxbox-cvs/cdk;protocol=git;tag=${SRC_REV} \
	http://dreamboxupdate.com/download/opendreambox/tuxbox-common-r11.tar.gz \
	file://satellites_20130124.patch;patch=1;pnum=1 \
"

FILES_${PN} = "/"

#S = "${WORKDIR}/tuxbox-common-r11 "
S = "${WORKDIR}/git/root_dream/share"

TRANSPONDER_LISTS = "satellites.xml terrestrial.xml"

#enigma1 need a cables.xml
TRANSPONDER_LISTS_append_dm7020 = " cables.xml"
TRANSPONDER_LISTS_append_dm500plus = " cables.xml"
TRANSPONDER_LISTS_append_dm600pvr = " cables.xml"

do_install() {
	install -d ${D}/etc/init.d
	install -d ${D}/etc/rcS.d
	install -d ${D}/etc/tuxbox/
	install -d ${D}/usr/share/tuxbox
	install -m 0644 ${WORKDIR}/tuxbox-common-r11/scart.conf ${D}/etc/tuxbox/scart.conf

	install -m 0644 ${WORKDIR}/tuxbox-common-r11/timezone.xml ${D}/etc/tuxbox/timezone.xml
	ln -sf /etc/tuxbox/timezone.xml ${D}/etc/

	ln -sf /usr/share ${D}/share

#		install -m 0644 ${WORKDIR}/tuxbox/$i ${D}/etc/tuxbox/$i
	for i in ${TRANSPONDER_LISTS}; do
		install -m 0644 ${S}/tuxbox/$i ${D}/etc/tuxbox/$i
		ln -sf /etc/tuxbox/$i ${D}/etc/;
		ln -sf /etc/tuxbox/$i ${D}/usr/share/;
		ln -sf /etc/tuxbox/$i ${D}/usr/share/tuxbox/;
	done;
}
