DESCRIPTION = "Qt/Embedded 2 Auxilliary libraries"
HOMEPAGE = "http://opie.handhelds.org"
SECTION = "opie/libs"
PRIORITY = "optional"
LICENSE = "GPL"

S = "${WORKDIR}/libqtaux"

inherit opie

do_compile() {
	install -d ${STAGING_INCDIR}/opie2
	for i in `find . -name "*.h"`
	do
		install -m 0644 $i ${STAGING_INCDIR}/opie2/`basename $i`
	done
	oe_runmake MOC=${STAGING_BINDIR_NATIVE}/moc UIC=${STAGING_BINDIR_NATIVE}/uic DESTDIR=${S}
}

do_stage() {
	oe_libinstall -so libqtaux2 ${STAGING_LIBDIR}
}

do_install() {
	oe_libinstall -so libqtaux2 ${D}${libdir}
}
