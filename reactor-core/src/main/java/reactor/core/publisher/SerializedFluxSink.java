/*
 * Copyright (c) 2019-Present Pivotal Software Inc, All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package reactor.core.publisher;

/**
 * A {@link FluxSink} that is serialized, making it suitable for multi-threaded producers,
 * and has a method to quickly try to emit data or fail fast (see {@link #tryNext(Object)}).
 *
 * @param <T> the value type
 */
public interface SerializedFluxSink<T> extends FluxSink<T> {

	/**
	 * Attempt to emit the value if there is enough request.
	 * Returns {@code false} if the sink is either terminated/cancelled, has not enough request
	 * or if there is a concurrent call to {@link #next(Object)}.
	 *
	 * @param value the value to attempt emitting
	 * @return true if the value was directly emitted downstream, false otherwise
	 */
	boolean tryNext(T value);

}