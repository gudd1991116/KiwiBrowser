
// Copyright 2024 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by
//     java_cpp_enum.py
// From
//     ../../components/ntp_snippets/contextual/contextual_suggestions_reporter.h

package org.chromium.chrome.browser.contextual_suggestions;

import androidx.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IntDef({
    ContextualSuggestionsEvent.UNINITIALIZED, ContextualSuggestionsEvent.FETCH_DELAYED,
    ContextualSuggestionsEvent.FETCH_REQUESTED, ContextualSuggestionsEvent.FETCH_ERROR,
    ContextualSuggestionsEvent.FETCH_SERVER_BUSY, ContextualSuggestionsEvent.FETCH_BELOW_THRESHOLD,
    ContextualSuggestionsEvent.FETCH_EMPTY, ContextualSuggestionsEvent.FETCH_COMPLETED,
    ContextualSuggestionsEvent.UI_PEEK_REVERSE_SCROLL, ContextualSuggestionsEvent.UI_OPENED,
    ContextualSuggestionsEvent.UI_CLOSED_OBSOLETE, ContextualSuggestionsEvent.SUGGESTION_DOWNLOADED,
    ContextualSuggestionsEvent.SUGGESTION_CLICKED,
    ContextualSuggestionsEvent.UI_DISMISSED_WITHOUT_OPEN,
    ContextualSuggestionsEvent.UI_DISMISSED_AFTER_OPEN, ContextualSuggestionsEvent.MAX_VALUE
})
@Retention(RetentionPolicy.SOURCE)
public @interface ContextualSuggestionsEvent {
  /**
   * Indicates that this state is not initialized. Should never be intentionally recorded, just used
   * as a default value.
   */
  int UNINITIALIZED = 0;
  /**
   * Records that fetching suggestions has been delayed on the client side.
   */
  int FETCH_DELAYED = 1;
  /**
   * The fetch request has been made but a response has not yet been received.
   */
  int FETCH_REQUESTED = 2;
  /**
   * The fetch response has been received, but there was some error.
   */
  int FETCH_ERROR = 3;
  /**
   * The fetch response indicates that the server was too busy to return any suggestions.
   */
  int FETCH_SERVER_BUSY = 4;
  /**
   * The fetch response includes suggestions but they were all below the confidence threshold needed
   * to show them to the user.
   */
  int FETCH_BELOW_THRESHOLD = 5;
  /**
   * The fetch response has been received and parsed, but there were no suggestions.
   */
  int FETCH_EMPTY = 6;
  /**
   * The fetch response has been received and there are suggestions to show.
   */
  int FETCH_COMPLETED = 7;
  /**
   * The UI was shown in the "peeking bar" state, triggered by a reverse-scroll. If new gestures are
   * added to trigger the peeking sheet then a new event should be added to this list.
   */
  int UI_PEEK_REVERSE_SCROLL = 8;
  /**
   * The UI sheet was opened.
   */
  int UI_OPENED = 9;
  /**
   * The UI was closed. General event for closed/dismissed, now obsolete.
   */
  int UI_CLOSED_OBSOLETE = 10;
  /**
   * A suggestion was downloaded.
   */
  int SUGGESTION_DOWNLOADED = 11;
  /**
   * A suggestion was taken, either with a click, or opened in a separate tab.
   */
  int SUGGESTION_CLICKED = 12;
  /**
   * The UI was dismissed without ever being opened. This means the sheet was closed while peeked
   * before ever being expanded.
   */
  int UI_DISMISSED_WITHOUT_OPEN = 13;
  /**
   * The UI was dismissed after having been opened. This means the sheet was closed from any
   * position after it was expanded at least once.
   */
  int UI_DISMISSED_AFTER_OPEN = 14;
  /**
   * Special name that marks the maximum value in an Enum used for UMA.
   * https://cs.chromium.org/chromium/src/tools/metrics/histograms/README.md.
   */
  int MAX_VALUE = UI_DISMISSED_AFTER_OPEN;
}
