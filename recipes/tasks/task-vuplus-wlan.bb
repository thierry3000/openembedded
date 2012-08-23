DESCRIPTION = "Vuplus: W-LAN Task for the Vuplus Distribution"
SECTION = "vuplus/base"
LICENSE = "MIT"
PR = "r6"

inherit task

#
# task-vuplus-wlan
#
DESCRIPTION_${PN} = "Vuplus: W-LAN Support"
DEPENDS_${PN} = "enigma2-plugins"
RDEPENDS_${PN} = "\
  ${@base_contains("MACHINE_FEATURES", "vuwlan", "enigma2-plugin-systemplugins-wirelesslansetup", "enigma2-plugin-systemplugins-wirelesslan", d)} \
  wireless-tools \
  wpa-supplicant \
"

WLAN_CRYPTO_MODULES = "\
"

WLAN_PCI_MODULES = "\
  kernel-module-ath5k \
"

WLAN_USB_MODULES = "\
  kernel-module-rt73usb \
  kernel-module-zd1211rw \
  rt73-firmware \
  zd1211-firmware \
  r8192cu \
  rt2870sta \
"

WLAN_USB_MODULES_LEGACY = "\
#  zd1211b \
#  wlan-rt73 \
#  r8712u \
  rt3070 \
  r8192cu \
"

RDEPENDS_${PN}_append_bm750 = "\
  ${@base_contains('PREFERRED_VERSION_linux-bm750', '2.6.18', '${WLAN_USB_MODULES_LEGACY}', '${WLAN_CRYPTO_MODULES} ${WLAN_USB_MODULES}', d)} \
"

RDEPENDS_${PN}_append_vusolo = "\
  ${@base_contains('PREFERRED_VERSION_linux-vusolo', '2.6.18', '${WLAN_USB_MODULES_LEGACY}', '${WLAN_CRYPTO_MODULES} ${WLAN_USB_MODULES}', d)} \
"

RDEPENDS_${PN}_append_vuuno = "\
  ${@base_contains('PREFERRED_VERSION_linux-vuuno', '2.6.18', '${WLAN_USB_MODULES_LEGACY}', '${WLAN_CRYPTO_MODULES} ${WLAN_USB_MODULES}', d)} \
"

RDEPENDS_${PN}_append_vuultimo = "\
  ${@base_contains('PREFERRED_VERSION_linux-vuultimo', '2.6.18', '${WLAN_USB_MODULES_LEGACY}', '${WLAN_CRYPTO_MODULES} ${WLAN_USB_MODULES}', d)} \
"
RDEPENDS_${PN}_append_vu7425 = "\
  ${@base_contains('PREFERRED_VERSION_linux-vuvu7425', '2.6.18', '${WLAN_USB_MODULES_LEGACY}', '${WLAN_CRYPTO_MODULES} ${WLAN_USB_MODULES}', d)} \
"
#RDEPENDS_${PN}_append_vuduo2 = "\
#  ${@base_contains('PREFERRED_VERSION_linux-vuduo2', '2.6.18', '${WLAN_USB_MODULES_LEGACY}', '${WLAN_CRYPTO_MODULES} ${WLAN_USB_MODULES}', d)} \
#"

RDEPENDS_${PN}_append_vuduo2 = '${WLAN_USB_MODULES_LEGACY}'
RDEPENDS_${PN}_append_vusolo2 = '${WLAN_USB_MODULES_LEGACY}'


PACKAGE_ARCH = "${MACHINE_ARCH}"

