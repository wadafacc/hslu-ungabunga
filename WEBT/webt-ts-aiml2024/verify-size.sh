#!/usr/bin/env bash

set -euo pipefail

verify_size() {
  local required_cmds=("tokei" "jq")

  for cmd in "${required_cmds[@]}"; do
    if ! type "$cmd" &> /dev/null; then
      echo "$cmd needs to be installed and available for this script to run" >&2
    fi
  done

  local stats
  stats=$(tokei --output json -e data)

  local html_code
  local css_code
  local js_code
  html_code=$(echo "$stats" | jq '.HTML.code')
  css_code=$(echo "$stats" | jq '.CSS.code')
  js_code=$(echo "$stats" | jq '.JavaScript.code')

  local max_html_code="200"
  local max_css_code="200"
  local max_js_code="400"

  local fail=0

  if (( "$html_code" > "$max_html_code" )); then
    echo "Too many HTML code lines. Max: $max_html_code, Used: $html_code"
    fail=$((fail + 1))
  fi

  if (( "$css_code" > "$max_css_code" )); then
    echo "Too many CSS code lines. Max: $max_css_code, Used: $css_code"
    fail=$((fail + 2))
  fi

  if (( "$js_code" > "$max_js_code" )); then
    echo "Too many JS code lines. Max: $max_js_code, Used: $js_code"
    fail=$((fail + 4))
  fi

  echo "HTML: $html_code, CSS: $css_code, JS: $js_code"

  exit "$fail"
}

verify_size