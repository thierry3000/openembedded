require openvpn.inc
PR = "r1"

SRC_URI = "http://openvpn.net/release/openvpn-2.1_rc20.tar.gz \
	   file://openvpn"

inherit update-rc.d

S = "${WORKDIR}/openvpn-2.1_rc20"

# I want openvpn to be able to read password from file (hrw)
EXTRA_OECONF += "--enable-password-save"

INITSCRIPT_NAME = "openvpn"

INITSCRIPT_PARAMS = "defaults"

