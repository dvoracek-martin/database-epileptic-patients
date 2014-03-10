/**
 * version 2.1.32
 * @license
 * =========================================================
 * bootstrap-datetimepicker.js
 * http://www.eyecon.ro/bootstrap-datepicker
 * =========================================================
 * Copyright 2012 Stefan Petre
 *
 * Contributions:
 * - updated for Bootstrap v3 by Jonathan Peterson (@Eonasdan) and (almost)
 *    completely rewritten to use Momentjs
 * - based on tarruda's bootstrap-datepicker
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================================================
 */
(function (a) {
    if (typeof define === "function" && define.amd) {
        define(["jquery", "../../moment/moment"], a)
    } else {
        if (!jQuery) {
            throw"bootstrap-datetimepicker requires jQuery to be loaded first"
        } else {
            if (!moment) {
                throw"bootstrap-datetimepicker requires moment.js to be loaded first"
            } else {
                a(jQuery, moment)
            }
        }
    }
}(function (d, e) {
    if (typeof e === "undefined") {
        alert("momentjs is requried");
        throw new Error("momentjs is required")
    }
    var c = 0, a = e, b = function (o, q) {
        var z = {pickDate: true, pickTime: true, useMinutes: true, useSeconds: false, minuteStepping: 1, startDate: new a({y: 1970}), endDate: new a().add(50, "y"), collapse: true, language: "en", defaultDate: "", disabledDates: [], enabledDates: false, icons: {}, useStrict: false, direction: "auto"}, M = {time: "glyphicon glyphicon-time", date: "glyphicon glyphicon-calendar", up: "glyphicon glyphicon-chevron-up", down: "glyphicon glyphicon-chevron-down"}, l = this, I = function () {
            var S = false, R, T, Q;
            l.options = d.extend({}, z, q);
            l.options.icons = d.extend({}, M, l.options.icons);
            l.element = d(o);
            f();
            if (!(l.options.pickTime || l.options.pickDate)) {
                throw new Error("Must choose at least one picker")
            }
            l.id = c++;
            a.lang(l.options.language);
            l.date = a();
            l.unset = false;
            l.isInput = l.element.is("input");
            l.component = false;
            if (l.element.hasClass("input-group")) {
                if (l.element.find(".datepickerbutton").size() == 0) {
                    l.component = l.element.find("[class^='input-group-']")
                } else {
                    l.component = l.element.find(".datepickerbutton")
                }
            }
            l.format = l.options.format;
            Q = a()._lang._longDateFormat;
            if (!l.format) {
                if (l.isInput) {
                    l.format = l.element.data("format")
                } else {
                    l.format = l.element.find("input").data("format")
                }
                if (!l.format) {
                    l.format = (l.options.pickDate ? Q.L : "");
                    if (l.options.pickDate && l.options.pickTime) {
                        l.format += " "
                    }
                    l.format += (l.options.pickTime ? Q.LT : "");
                    if (l.options.useSeconds) {
                        if (~Q.LT.indexOf(" A")) {
                            l.format = l.format.split(" A")[0] + ":ss A"
                        } else {
                            l.format += ":ss"
                        }
                    }
                }
            }
            l.options.use24hours = l.format.toLowerCase().indexOf("a") < 1;
            if (l.component) {
                S = l.component.find("span")
            }
            if (l.options.pickTime) {
                if (S) {
                    S.addClass(l.options.icons.time)
                }
            }
            if (l.options.pickDate) {
                if (S) {
                    S.removeClass(l.options.icons.time);
                    S.addClass(l.options.icons.date)
                }
            }
            l.widget = d(P(l.options.pickDate, l.options.pickTime, l.options.collapse)).appendTo("body");
            l.minViewMode = l.options.minViewMode || l.element.data("date-minviewmode") || 0;
            if (typeof l.minViewMode === "string") {
                switch (l.minViewMode) {
                    case"months":
                        l.minViewMode = 1;
                        break;
                    case"years":
                        l.minViewMode = 2;
                        break;
                    default:
                        l.minViewMode = 0;
                        break
                }
            }
            l.viewMode = l.options.viewMode || l.element.data("date-viewmode") || 0;
            if (typeof l.viewMode === "string") {
                switch (l.viewMode) {
                    case"months":
                        l.viewMode = 1;
                        break;
                    case"years":
                        l.viewMode = 2;
                        break;
                    default:
                        l.viewMode = 0;
                        break
                }
            }
            for (R = 0; R < l.options.disabledDates.length; R++) {
                T = l.options.disabledDates[R];
                T = a(T);
                if (!T.isValid()) {
                    T = a(l.options.startDate).subtract(1, "day")
                }
                l.options.disabledDates[R] = T.format("L")
            }
            for (R = 0; R < l.options.enabledDates.length; R++) {
                T = l.options.enabledDates[R];
                T = a(T);
                if (!T.isValid()) {
                    T = a(l.options.startDate).subtract(1, "day")
                }
                l.options.enabledDates[R] = T.format("L")
            }
            l.startViewMode = l.viewMode;
            l.setStartDate(l.options.startDate || l.element.data("date-startdate"));
            l.setEndDate(l.options.endDate || l.element.data("date-enddate"));
            H();
            u();
            v();
            t();
            h();
            y();
            g();
            J();
            if (l.options.defaultDate !== "") {
                l.setValue(l.options.defaultDate)
            }
        }, f = function () {
            var Q = l.element.data();
            if (Q.pickdate !== undefined) {
                l.options.pickDate = Q.pickdate
            }
            if (Q.picktime !== undefined) {
                l.options.pickTime = Q.picktime
            }
            if (Q.useminutes !== undefined) {
                l.options.useMinutes = Q.useminutes
            }
            if (Q.useseconds !== undefined) {
                l.options.useSeconds = Q.useseconds
            }
            if (Q.minutestepping !== undefined) {
                l.options.minuteStepping = Q.minutestepping
            }
            if (Q.startdate !== undefined) {
                l.options.startDate = Q.startdate
            }
            if (Q.enddate !== undefined) {
                l.options.endDate = Q.enddate
            }
            if (Q.collapse !== undefined) {
                l.options.collapse = Q.collapse
            }
            if (Q.language !== undefined) {
                l.options.language = Q.language
            }
            if (Q.defaultdate !== undefined) {
                l.options.defaultDate = Q.defaultdate
            }
            if (Q.disableddates !== undefined) {
                l.options.disabledDates = Q.disableddates
            }
            if (Q.enableddates !== undefined) {
                l.options.enabledDates = Q.enableddates
            }
            if (Q.icons !== undefined) {
                l.options.icons = Q.icons
            }
            if (Q.usestrict !== undefined) {
                l.options.useStrict = Q.usestrict
            }
        }, j = function () {
            var Q = "absolute", S = l.component ? l.component.offset() : l.element.offset(), R = d(window);
            l.width = l.component ? l.component.outerWidth() : l.element.outerWidth();
            S.top = S.top + l.element.outerHeight();
            if (l.options.width !== undefined) {
                l.widget.width(l.options.width)
            }
            if (l.options.orientation === "left") {
                l.widget.addClass("left-oriented");
                S.left = S.left - l.widget.width() + 20
            }
            if (B()) {
                Q = "fixed";
                S.top -= R.scrollTop();
                S.left -= R.scrollLeft()
            }
            if (R.width() < S.left + l.widget.outerWidth()) {
                S.right = R.width() - S.left - l.width;
                S.left = "auto";
                l.widget.addClass("pull-right")
            } else {
                S.right = "auto";
                l.widget.removeClass("pull-right")
            }
            l.widget.css({position: Q, top: S.top, left: S.left, right: S.right})
        }, p = function (R, Q) {
            l.element.trigger({type: "change.dp", date: a(l.date), oldDate: a(R)});
            if (Q !== "change") {
                l.element.change()
            }
        }, C = function (Q) {
            l.element.trigger({type: "error.dp", date: a(Q)})
        }, y = function (Q) {
            a.lang(l.options.language);
            var R = Q;
            if (!R) {
                if (l.isInput) {
                    R = l.element.val()
                } else {
                    R = l.element.find("input").val()
                }
                if (R) {
                    l.date = a(R, l.format, l.options.useStrict)
                }
                if (!l.date) {
                    l.date = a()
                }
            }
            l.viewDate = a(l.date).startOf("month");
            n();
            k()
        }, H = function () {
            a.lang(l.options.language);
            var S = d("<tr>"), Q = a.weekdaysMin(), R;
            if (a()._lang._week.dow == 0) {
                for (R = 0; R < 7; R++) {
                    S.append('<th class="dow">' + Q[R] + "</th>")
                }
            } else {
                for (R = 1; R < 8; R++) {
                    if (R == 7) {
                        S.append('<th class="dow">' + Q[0] + "</th>")
                    } else {
                        S.append('<th class="dow">' + Q[R] + "</th>")
                    }
                }
            }
            l.widget.find(".datepicker-days thead").append(S)
        }, u = function () {
            a.lang(l.options.language);
            var R = "", Q = 0, S = a.monthsShort();
            while (Q < 12) {
                R += '<span class="month">' + S[Q++] + "</span>"
            }
            l.widget.find(".datepicker-months td").append(R)
        }, n = function () {
            a.lang(l.options.language);
            var ab = l.viewDate.year(), Z = l.viewDate.month(), aa = l.options.startDate.year(), ad = l.options.startDate.month(), ae = l.options.endDate.year(), X = l.options.endDate.month(), T, W, V = [], af, S, U, ac, R, Y, Q = a.months();
            l.widget.find(".datepicker-days").find(".disabled").removeClass("disabled");
            l.widget.find(".datepicker-months").find(".disabled").removeClass("disabled");
            l.widget.find(".datepicker-years").find(".disabled").removeClass("disabled");
            l.widget.find(".datepicker-days th:eq(1)").text(Q[Z] + " " + ab);
            T = a(l.viewDate).subtract("months", 1);
            ac = T.daysInMonth();
            T.date(ac).startOf("week");
            if ((ab == aa && Z <= ad) || ab < aa) {
                l.widget.find(".datepicker-days th:eq(0)").addClass("disabled")
            }
            if ((ab == ae && Z >= X) || ab > ae) {
                l.widget.find(".datepicker-days th:eq(2)").addClass("disabled")
            }
            W = a(T).add(42, "d");
            while (T.isBefore(W)) {
                if (T.weekday() === a().startOf("week").weekday()) {
                    af = d("<tr>");
                    V.push(af)
                }
                S = "";
                if (T.year() < ab || (T.year() == ab && T.month() < Z)) {
                    S += " old"
                } else {
                    if (T.year() > ab || (T.year() == ab && T.month() > Z)) {
                        S += " new"
                    }
                }
                if (T.isSame(a({y: l.date.year(), M: l.date.month(), d: l.date.date()}))) {
                    S += " active"
                }
                if (O(T) || !s(T)) {
                    S += " disabled"
                }
                af.append('<td class="day' + S + '">' + T.date() + "</td>");
                T.add(1, "d")
            }
            l.widget.find(".datepicker-days tbody").empty().append(V);
            Y = a().year(), Q = l.widget.find(".datepicker-months").find("th:eq(1)").text(ab).end().find("span").removeClass("active");
            if (Y === ab) {
                Q.eq(a().month()).addClass("active")
            }
            if (Y - 1 < aa) {
                l.widget.find(".datepicker-months th:eq(0)").addClass("disabled")
            }
            if (Y + 1 > ae) {
                l.widget.find(".datepicker-months th:eq(2)").addClass("disabled")
            }
            for (U = 0; U < 12; U++) {
                if ((ab == aa && ad > U) || (ab < aa)) {
                    d(Q[U]).addClass("disabled")
                } else {
                    if ((ab == ae && X < U) || (ab > ae)) {
                        d(Q[U]).addClass("disabled")
                    }
                }
            }
            V = "";
            ab = parseInt(ab / 10, 10) * 10;
            R = l.widget.find(".datepicker-years").find("th:eq(1)").text(ab + "-" + (ab + 9)).end().find("td");
            l.widget.find(".datepicker-years").find("th").removeClass("disabled");
            if (aa > ab) {
                l.widget.find(".datepicker-years").find("th:eq(0)").addClass("disabled")
            }
            if (ae < ab + 9) {
                l.widget.find(".datepicker-years").find("th:eq(2)").addClass("disabled")
            }
            ab -= 1;
            for (U = -1; U < 11; U++) {
                V += '<span class="year' + (U === -1 || U === 10 ? " old" : "") + (Y === ab ? " active" : "") + ((ab < aa || ab > ae) ? " disabled" : "") + '">' + ab + "</span>";
                ab += 1
            }
            R.html(V)
        }, v = function () {
            a.lang(l.options.language);
            var T = l.widget.find(".timepicker .timepicker-hours table"), S = "", U, R, Q;
            T.parent().hide();
            if (l.options.use24hours) {
                U = 0;
                for (R = 0; R < 6; R += 1) {
                    S += "<tr>";
                    for (Q = 0; Q < 4; Q += 1) {
                        S += '<td class="hour">' + N(U.toString()) + "</td>";
                        U++
                    }
                    S += "</tr>"
                }
            } else {
                U = 1;
                for (R = 0; R < 3; R += 1) {
                    S += "<tr>";
                    for (Q = 0; Q < 4; Q += 1) {
                        S += '<td class="hour">' + N(U.toString()) + "</td>";
                        U++
                    }
                    S += "</tr>"
                }
            }
            T.html(S)
        }, t = function () {
            var T = l.widget.find(".timepicker .timepicker-minutes table"), S = "", U = 0, R, Q;
            T.parent().hide();
            for (R = 0; R < 5; R++) {
                S += "<tr>";
                for (Q = 0; Q < 4; Q += 1) {
                    S += '<td class="minute">' + N(U.toString()) + "</td>";
                    U += 3
                }
                S += "</tr>"
            }
            T.html(S)
        }, h = function () {
            var T = l.widget.find(".timepicker .timepicker-seconds table"), S = "", U = 0, R, Q;
            T.parent().hide();
            for (R = 0; R < 5; R++) {
                S += "<tr>";
                for (Q = 0; Q < 4; Q += 1) {
                    S += '<td class="second">' + N(U.toString()) + "</td>";
                    U += 3
                }
                S += "</tr>"
            }
            T.html(S)
        }, k = function () {
            if (!l.date) {
                return
            }
            var S = l.widget.find(".timepicker span[data-time-component]"), Q = l.date.hours(), R = "AM";
            if (!l.options.use24hours) {
                if (Q >= 12) {
                    R = "PM"
                }
                if (Q === 0) {
                    Q = 12
                } else {
                    if (Q != 12) {
                        Q = Q % 12
                    }
                }
                l.widget.find(".timepicker [data-action=togglePeriod]").text(R)
            }
            S.filter("[data-time-component=hours]").text(N(Q));
            S.filter("[data-time-component=minutes]").text(N(l.date.minutes()));
            S.filter("[data-time-component=seconds]").text(N(l.date.second()))
        }, A = function (W) {
            W.stopPropagation();
            W.preventDefault();
            l.unset = false;
            var V = d(W.target).closest("span, td, th"), U, S, T, Q, R = a(l.date);
            if (V.length === 1) {
                if (!V.is(".disabled")) {
                    switch (V[0].nodeName.toLowerCase()) {
                        case"th":
                            switch (V[0].className) {
                                case"switch":
                                    g(1);
                                    break;
                                case"prev":
                                case"next":
                                    T = w.modes[l.viewMode].navStep;
                                    if (V[0].className === "prev") {
                                        T = T * -1
                                    }
                                    l.viewDate.add(T, w.modes[l.viewMode].navFnc);
                                    n();
                                    break
                            }
                            break;
                        case"span":
                            if (V.is(".month")) {
                                U = V.parent().find("span").index(V);
                                l.viewDate.month(U)
                            } else {
                                S = parseInt(V.text(), 10) || 0;
                                l.viewDate.year(S)
                            }
                            if (l.viewMode !== 0) {
                                l.date = a({y: l.viewDate.year(), M: l.viewDate.month(), d: l.viewDate.date(), h: l.date.hours(), m: l.date.minutes()});
                                p(R, W.type)
                            }
                            g(-1);
                            n();
                            break;
                        case"td":
                            if (V.is(".day")) {
                                Q = parseInt(V.text(), 10) || 1;
                                U = l.viewDate.month();
                                S = l.viewDate.year();
                                if (V.is(".old")) {
                                    if (U === 0) {
                                        U = 11;
                                        S -= 1
                                    } else {
                                        U -= 1
                                    }
                                } else {
                                    if (V.is(".new")) {
                                        if (U == 11) {
                                            U = 0;
                                            S += 1
                                        } else {
                                            U += 1
                                        }
                                    }
                                }
                                l.date = a({y: S, M: U, d: Q, h: l.date.hours(), m: l.date.minutes()});
                                l.viewDate = a({y: S, M: U, d: Math.min(28, Q)});
                                n();
                                r();
                                p(R, W.type)
                            }
                            break
                    }
                }
            }
        }, D = {incrementHours: function () {
            m("add", "hours", 1)
        }, incrementMinutes: function () {
            m("add", "minutes", l.options.minuteStepping)
        }, incrementSeconds: function () {
            m("add", "seconds", 1)
        }, decrementHours: function () {
            m("subtract", "hours", 1)
        }, decrementMinutes: function () {
            m("subtract", "minutes", l.options.minuteStepping)
        }, decrementSeconds: function () {
            m("subtract", "seconds", 1)
        }, togglePeriod: function () {
            var Q = l.date.hours();
            if (Q >= 12) {
                Q -= 12
            } else {
                Q += 12
            }
            l.date.hours(Q)
        }, showPicker: function () {
            l.widget.find(".timepicker > div:not(.timepicker-picker)").hide();
            l.widget.find(".timepicker .timepicker-picker").show()
        }, showHours: function () {
            l.widget.find(".timepicker .timepicker-picker").hide();
            l.widget.find(".timepicker .timepicker-hours").show()
        }, showMinutes: function () {
            l.widget.find(".timepicker .timepicker-picker").hide();
            l.widget.find(".timepicker .timepicker-minutes").show()
        }, showSeconds: function () {
            l.widget.find(".timepicker .timepicker-picker").hide();
            l.widget.find(".timepicker .timepicker-seconds").show()
        }, selectHour: function (Q) {
            l.date.hours(parseInt(d(Q.target).text(), 10));
            D.showPicker.call(l)
        }, selectMinute: function (Q) {
            l.date.minutes(parseInt(d(Q.target).text(), 10));
            D.showPicker.call(l)
        }, selectSecond: function (Q) {
            l.date.seconds(parseInt(d(Q.target).text(), 10));
            D.showPicker.call(l)
        }}, x = function (S) {
            var Q = a(l.date), R = d(S.currentTarget).data("action"), T = D[R].apply(l, arguments);
            K(S);
            if (!l.date) {
                l.date = a({y: 1970})
            }
            r();
            k();
            p(Q, S.type);
            return T
        }, K = function (Q) {
            Q.stopPropagation();
            Q.preventDefault()
        }, i = function (T) {
            a.lang(l.options.language);
            var R = d(T.target), S = a(l.date), Q = a(R.val(), l.format, l.options.useStrict);
            if (Q.isValid() && !O(Q) && s(Q)) {
                y();
                l.setValue(Q);
                p(S, T.type);
                r()
            } else {
                l.viewDate = S;
                p(S, T.type);
                C(Q);
                l.unset = true
            }
        }, g = function (Q) {
            if (Q) {
                l.viewMode = Math.max(l.minViewMode, Math.min(2, l.viewMode + Q))
            }
            l.widget.find(".datepicker > div").hide().filter(".datepicker-" + w.modes[l.viewMode].clsName).show()
        }, J = function () {
            var U, T, R, Q, S;
            l.widget.on("click", ".datepicker *", d.proxy(A, this));
            l.widget.on("click", "[data-action]", d.proxy(x, this));
            l.widget.on("mousedown", d.proxy(K, this));
            if (l.options.pickDate && l.options.pickTime) {
                l.widget.on("click.togglePicker", ".accordion-toggle", function (V) {
                    V.stopPropagation();
                    U = d(this);
                    T = U.closest("ul");
                    R = T.find(".in");
                    Q = T.find(".collapse:not(.in)");
                    if (R && R.length) {
                        S = R.data("collapse");
                        if (S && S.transitioning) {
                            return
                        }
                        R.collapse("hide");
                        Q.collapse("show");
                        U.find("span").toggleClass(l.options.icons.time + " " + l.options.icons.date);
                        l.element.find(".input-group-addon span").toggleClass(l.options.icons.time + " " + l.options.icons.date)
                    }
                })
            }
            if (l.isInput) {
                l.element.on({focus: d.proxy(l.show, this), change: d.proxy(i, this), blur: d.proxy(l.hide, this)})
            } else {
                l.element.on({change: d.proxy(i, this)}, "input");
                if (l.component) {
                    l.component.on("click", d.proxy(l.show, this))
                } else {
                    l.element.on("click", d.proxy(l.show, this))
                }
            }
        }, L = function () {
            d(window).on("resize.datetimepicker" + l.id, d.proxy(j, this));
            if (!l.isInput) {
                d(document).on("mousedown.datetimepicker" + l.id, d.proxy(l.hide, this))
            }
        }, F = function () {
            l.widget.off("click", ".datepicker *", l.click);
            l.widget.off("click", "[data-action]");
            l.widget.off("mousedown", l.stopEvent);
            if (l.options.pickDate && l.options.pickTime) {
                l.widget.off("click.togglePicker")
            }
            if (l.isInput) {
                l.element.off({focus: l.show, change: l.change})
            } else {
                l.element.off({change: l.change}, "input");
                if (l.component) {
                    l.component.off("click", l.show)
                } else {
                    l.element.off("click", l.show)
                }
            }
        }, E = function () {
            d(window).off("resize.datetimepicker" + l.id);
            if (!l.isInput) {
                d(document).off("mousedown.datetimepicker" + l.id)
            }
        }, B = function () {
            if (l.element) {
                var R = l.element.parents(), Q = false, S;
                for (S = 0; S < R.length; S++) {
                    if (d(R[S]).css("position") == "fixed") {
                        Q = true;
                        break
                    }
                }
                return Q
            } else {
                return false
            }
        }, r = function () {
            a.lang(l.options.language);
            var R = "", Q;
            if (!l.unset) {
                R = a(l.date).format(l.format)
            }
            if (!l.isInput) {
                if (l.component) {
                    Q = l.element.find("input");
                    Q.val(R)
                }
                l.element.data("date", R)
            } else {
                l.element.val(R)
            }
            if (!l.options.pickTime) {
                l.hide()
            }
        }, m = function (T, S, R) {
            a.lang(l.options.language);
            var Q;
            if (T == "add") {
                Q = a(l.date);
                if (Q.hours() == 23) {
                    Q.add(R, S)
                }
                Q.add(R, S)
            } else {
                Q = a(l.date).subtract(R, S)
            }
            if (O(a(Q.subtract(R, S))) || O(Q)) {
                C(Q.format(l.format));
                return
            }
            if (T == "add") {
                l.date.add(R, S)
            } else {
                l.date.subtract(R, S)
            }
            l.unset = false
        }, O = function (Q) {
            a.lang(l.options.language);
            if (Q.isAfter(l.options.endDate) || Q.isBefore(l.options.startDate)) {
                return true
            }
            var S = l.options.disabledDates, R;
            for (R in S) {
                if (S[R] == a(Q).format("L")) {
                    return true
                }
            }
            return false
        }, s = function (R) {
            a.lang(l.options.language);
            var Q = l.options.enabledDates, S;
            if (Q.length) {
                for (S in Q) {
                    if (Q[S] == a(R).format("L")) {
                        return true
                    }
                }
                return false
            }
            return Q === false ? true : false
        }, N = function (Q) {
            Q = Q.toString();
            if (Q.length >= 2) {
                return Q
            } else {
                return"0" + Q
            }
        }, P = function (R, Q, S) {
            if (R && Q) {
                return('<div class="bootstrap-datetimepicker-widget dropdown-menu" style="z-index:9999 !important;"><ul class="list-unstyled"><li' + (S ? ' class="collapse in"' : "") + '><div class="datepicker">' + w.template + '</div></li><li class="picker-switch accordion-toggle"><a class="btn" style="width:100%"><span class="' + l.options.icons.time + '"></span></a></li><li' + (S ? ' class="collapse"' : "") + '><div class="timepicker">' + G.getTemplate() + "</div></li></ul></div>")
            } else {
                if (Q) {
                    return('<div class="bootstrap-datetimepicker-widget dropdown-menu"><div class="timepicker">' + G.getTemplate() + "</div></div>")
                } else {
                    return('<div class="bootstrap-datetimepicker-widget dropdown-menu"><div class="datepicker">' + w.template + "</div></div>")
                }
            }
        }, w = {modes: [
            {clsName: "days", navFnc: "month", navStep: 1},
            {clsName: "months", navFnc: "year", navStep: 1},
            {clsName: "years", navFnc: "year", navStep: 10}
        ], headTemplate: '<thead><tr><th class="prev">&lsaquo;</th><th colspan="5" class="switch"></th><th class="next">&rsaquo;</th></tr></thead>', contTemplate: '<tbody><tr><td colspan="7"></td></tr></tbody>'}, G = {hourTemplate: '<span data-action="showHours"   data-time-component="hours"   class="timepicker-hour"></span>', minuteTemplate: '<span data-action="showMinutes" data-time-component="minutes" class="timepicker-minute"></span>', secondTemplate: '<span data-action="showSeconds"  data-time-component="seconds" class="timepicker-second"></span>'};
        w.template = '<div class="datepicker-days"><table class="table-condensed">' + w.headTemplate + '<tbody></tbody></table></div><div class="datepicker-months"><table class="table-condensed">' + w.headTemplate + w.contTemplate + '</table></div><div class="datepicker-years"><table class="table-condensed">' + w.headTemplate + w.contTemplate + "</table></div>";
        G.getTemplate = function () {
            return('<div class="timepicker-picker"><table class="table-condensed"><tr><td><a href="#" class="btn" data-action="incrementHours"><span class="' + l.options.icons.up + '"></span></a></td><td class="separator"></td><td>' + (l.options.useMinutes ? '<a href="#" class="btn" data-action="incrementMinutes"><span class="' + l.options.icons.up + '"></span></a>' : "") + "</td>" + (l.options.useSeconds ? '<td class="separator"></td><td><a href="#" class="btn" data-action="incrementSeconds"><span class="' + l.options.icons.up + '"></span></a></td>' : "") + (l.options.use24hours ? "" : '<td class="separator"></td>') + "</tr><tr><td>" + G.hourTemplate + '</td> <td class="separator">:</td><td>' + (l.options.useMinutes ? G.minuteTemplate : '<span class="timepicker-minute">00</span>') + "</td> " + (l.options.useSeconds ? '<td class="separator">:</td><td>' + G.secondTemplate + "</td>" : "") + (l.options.use24hours ? "" : '<td class="separator"></td><td><button type="button" class="btn btn-primary" data-action="togglePeriod"></button></td>') + '</tr><tr><td><a href="#" class="btn" data-action="decrementHours"><span class="' + l.options.icons.down + '"></span></a></td><td class="separator"></td><td>' + (l.options.useMinutes ? '<a href="#" class="btn" data-action="decrementMinutes"><span class="' + l.options.icons.down + '"></span></a>' : "") + "</td>" + (l.options.useSeconds ? '<td class="separator"></td><td><a href="#" class="btn" data-action="decrementSeconds"><span class="' + l.options.icons.down + '"></span></a></td>' : "") + (l.options.use24hours ? "" : '<td class="separator"></td>') + '</tr></table></div><div class="timepicker-hours" data-action="selectHour"><table class="table-condensed"></table></div><div class="timepicker-minutes" data-action="selectMinute"><table class="table-condensed"></table></div>' + (l.options.useSeconds ? '<div class="timepicker-seconds" data-action="selectSecond"><table class="table-condensed"></table></div>' : ""))
        };
        l.destroy = function () {
            F();
            E();
            l.widget.remove();
            l.element.removeData("DateTimePicker");
            if (l.component) {
                l.component.removeData("DateTimePicker")
            }
        };
        l.show = function (Q) {
            l.widget.show();
            l.height = l.component ? l.component.outerHeight() : l.element.outerHeight();
            j();
            l.element.trigger({type: "show.dp", date: a(l.date)});
            L();
            if (Q) {
                K(Q)
            }
        }, l.disable = function () {
            var Q = l.element.find("input");
            if (Q.prop("disabled")) {
                return
            }
            Q.prop("disabled", true);
            F()
        }, l.enable = function () {
            var Q = l.element.find("input");
            if (!Q.prop("disabled")) {
                return
            }
            Q.prop("disabled", false);
            J()
        }, l.hide = function (S) {
            if (S && d(S.target).is(l.element.attr("id"))) {
                return
            }
            var T = l.widget.find(".collapse"), Q, R;
            for (Q = 0; Q < T.length; Q++) {
                R = T.eq(Q).data("collapse");
                if (R && R.transitioning) {
                    return
                }
            }
            l.widget.hide();
            l.viewMode = l.startViewMode;
            g();
            l.element.trigger({type: "hide.dp", date: a(l.date)});
            E()
        }, l.setValue = function (Q) {
            a.lang(l.options.language);
            if (!Q) {
                l.unset = true;
                r()
            } else {
                l.unset = false
            }
            if (!a.isMoment(Q)) {
                Q = a(Q)
            }
            if (Q.isValid()) {
                l.date = Q;
                r();
                l.viewDate = a({y: l.date.year(), M: l.date.month()});
                n();
                k()
            } else {
                C(Q)
            }
        }, l.getDate = function () {
            if (l.unset) {
                return null
            }
            return l.date
        }, l.setDate = function (Q) {
            if (!Q) {
                l.setValue(null)
            } else {
                l.setValue(a(Q))
            }
        }, l.setEnabledDates = function (Q) {
            if (!Q) {
                l.options.enabledDates = false
            } else {
                l.options.enabledDates = Q
            }
            if (l.viewDate) {
                y()
            }
        }, l.setEndDate = function (Q) {
            if (Q == undefined) {
                return
            }
            l.options.endDate = a(Q);
            if (l.viewDate) {
                y()
            }
        }, l.setStartDate = function (Q) {
            if (Q == undefined) {
                return
            }
            l.options.startDate = a(Q);
            if (l.viewDate) {
                y()
            }
        };
        I()
    };
    d.fn.datetimepicker = function (f) {
        return this.each(function () {
            var h = d(this), g = h.data("DateTimePicker");
            if (!g) {
                h.data("DateTimePicker", new b(this, f))
            }
        })
    }
}));