DESCRIPTION = "Hardware drivers for VuPlus"
SECTION = "base"
PRIORITY = "required"
LICENSE = "proprietary"

KV = "${@base_contains('PREFERRED_VERSION_linux-${MACHINE}', '2.6.18', '2.6.18', '3.1.1', d)}"
KV_vusolo2 = "${@base_contains('PREFERRED_VERSION_linux-${MACHINE}', '2.6.37', '2.6.37', '3.3.6', d)}"
KV_vuduo2 = "${@base_contains('PREFERRED_VERSION_linux-${MACHINE}', '2.6.37', '2.6.37', '3.3.6', d)}"

PV = "${KV}"

inherit module

SRCDATE_bm750 = "20121025"
SRCDATE_vusolo = "20121025"
SRCDATE_vuuno = "20121025"
SRCDATE_vuultimo = "20121025"
SRCDATE_vuduo2 = "20121102"
SRCDATE_vusolo2 = "20121109"

MODULES_NAME_bm750 = "procmk\ndvb-bcm7335\nbrcmfb"
MODULES_NAME_vusolo = "procmk\ndvb-bcm7325\nbrcmfb"
MODULES_NAME_vuuno = "procmk\ndvb-bcm7413\nbrcmfb\nfpga_directc"
MODULES_NAME_vuultimo = "procmk\ndvb-bcm7413\nbrcmfb\nfpga_directc"
MODULES_NAME_vuduo2 = "procmk\ndvb-bcm7424\nbrcmfb\nfpga_directc"
MODULES_NAME_vusolo2 = "procmk\ndvb-bcm7356\nbrcmfb\nfpga_directc"

RDEPENDS_2.6.18 = "initscripts-vuplus kernel (${KV}) kernel-module-firmware-class kernel-module-input kernel-module-evdev kernel-module-i2c-core kernel-module-snd kernel-module-snd-pcm"
RDEPENDS_3.1 = "initscripts-vuplus kernel (${KV})" 

RDEPENDS = "\
  ${@base_contains('PREFERRED_VERSION_linux-${MACHINE}', '2.6.18', '${RDEPENDS_2.6.18}', '${RDEPENDS_3.1}', d)} \
"

PR = "r19-${SRCDATE}"

#hack
DEPENDS = " module-init-tools"
RDEPENDS_append_vuplus = " module-init-tools-depmod"

SRC_URI = "http://archive.vuplus.com/download/drivers/beta/private/vuplus-dvb-modules-${MACHINE}-${PV}-${PREFERRED_GCC_VERSION}-${SRCDATE}.tar.gz "

S = "${WORKDIR}"

do_install() {
        install -d ${D}/lib/modules/${KV}/extra
        for f in *.ko; do
                install -m 0644 ${WORKDIR}/$f ${D}/lib/modules/${KV}/extra/$f;
        done
	if [ "${KV}" = "3.1.1" ]; then
		install -d ${D}/etc/modutils
		echo -e "${MODULES_NAME}" > ${D}/etc/modutils/vuplus-dvb-modules
		echo -e "${MODULES_NAME}" > ${D}/etc/modules
	fi
}

do_install_vusolo2() {
        install -d ${D}/lib/modules/${KERNEL_VERSION}/extra
        for f in *.ko; do
                install -m 0644 ${WORKDIR}/$f ${D}/lib/modules/${KERNEL_VERSION}/extra/$f;
        done
	install -d ${D}/etc/modutils
	echo -e "${MODULES_NAME}" > ${D}/etc/modutils/vuplus-dvb-modules
	echo -e "${MODULES_NAME}" > ${D}/etc/modules
}

do_install_vuduo2() {
        install -d ${D}/lib/modules/${KERNEL_VERSION}/extra
        for f in *.ko; do
                install -m 0644 ${WORKDIR}/$f ${D}/lib/modules/${KERNEL_VERSION}/extra/$f;
        done
	install -d ${D}/etc/modutils
	echo -e "${MODULES_NAME}" > ${D}/etc/modutils/vuplus-dvb-modules
	echo -e "${MODULES_NAME}" > ${D}/etc/modules
}

pkg_postinst_vuplus-dvb-modules () {
        if [ -d /proc/stb ]; then
                depmod -ae
        fi
        true
}

do_compile () {
}


PACKAGE_ARCH := "${MACHINE_ARCH}"
FILES_${PN} = "/"
